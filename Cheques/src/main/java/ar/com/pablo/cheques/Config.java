package ar.com.pablo.cheques;

import ar.com.pablo.cheques.common.interfaces.AppInfo;
import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Descripción: Implementacion de IConfig
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 06/12/2019
 * @version 1.0
 */
public class Config implements IConfig {

    final String PROPERTIESfile = "config.properties";
    final String MSG01 = "No se ha encontrado Addons";
    String reportPath, addonsFolder;
    List<IAddon> addOns = null;
    Properties resources, defaultResources = null;

    public Config(boolean isLoadAddon, Properties ResourceProp) {
        Properties configData = new Properties();
        try {
            configData.load(Config.class.getResourceAsStream("/" + PROPERTIESfile));
        } catch (IOException ex) {
            System.out.println("No se puede cargar el archivo de configuracion");
        }

        this.addonsFolder = configData.getProperty("AddonsFolder");
        this.reportPath = configData.getProperty("ReportPath");

        resources = ResourceProp;

        if (compruebaInicio()) {
            if (isLoadAddon) {
                Addons addO = new Addons(this);
                addOns = addO.getAddons();

                if (null != addOns) {
                    if (addOns.size() > 0) {
                        System.out.println(ResourceProp.getProperty("MSG_02").trim());
                        System.out.println("================");
                        for (int i = 0; i < addOns.size(); i++) {
                            System.out.println("* " + addOns.get(i).getInfo().getAppName()
                                    + " v." + addOns.get(i).getInfo().getAppVersion());
                            addOns.get(i).init(this);
                        }
                    } else {
                        System.out.println(MSG01);
                    }
                } else {
                    System.out.println(MSG01);
                }
            } //False isLoadAddon
        } else {
            System.exit(1); //False compruebaInicio()
        }
    }

    @Override
    public String getReportPath() {
        return reportPath;
    }

    @Override
    public String getAddonsFolder() {
        return addonsFolder;
    }

    @Override
    public List<IAddon> getAddons() {
        return addOns;
    }

    @Override
    public void destroy() {
        if (null != addOns) {
            if (addOns.size() > 0) {
                for (int i = 0; i < addOns.size(); i++) {
                    addOns.get(i).destroy(this);
                }
            }
        }
    }

    /**
     * Comprueba que existan todos los archivos y carpetas 
     **/
    private boolean compruebaInicio() {
        if(!new File(reportPath).exists()){
            IConfig.showMessage(
                    getResourceText("MSG_BOX_TITLE"),
                    getResourceText("ERR_NO_REPORT"),
                    null);
            return false;
        }
        
        File folderAddons = new File(addonsFolder);
        if(!folderAddons.exists())
            folderAddons.mkdir();
     
        
        return true;
    }

    @Override
    public String getResourceText(String key) {
        String out;
        out = resources.getProperty(key);
        if (null == out) {
            if (null == defaultResources) {
                try {
                    defaultResources = new Properties();
                    defaultResources.load(IConfig.class.getResourceAsStream("/resources.properties"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                out = defaultResources.getProperty(key);

            }
        }
        return out.trim();
    }

    @Override
    public AppInfo appInfo() {
       return new AppInfo();
    }
}
