package ar.com.pablo.cheques;

import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import ar.com.pablo.cheques.common.libs.ClsRecursive;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

/**
 * Descripción: Gestiona los Addons
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 15/03/2020
 * @version 1.0
 */
public class Addons {

    private final String FILEEXTENSION = "add";
    private final String MANIFEST_ATTRIB = "Addon-Class";
    private final IConfig config;

    public Addons(IConfig config) {
        this.config = config;
    }

    //retorna todos los archivos con extension jar
    private File[] getAllfilesAddons() {
        ClsRecursive objRecursive = new ClsRecursive();
        return objRecursive.getFileListing(config.getAddonsFolder(),
                (File dir, String name) -> name.toLowerCase().endsWith("." + FILEEXTENSION));
    }

    /**
     * Busca la entrada en el Manifest Agrega la clase al ClassPath Crea una
     * nueva instancia del Addon
     *
     * @return Retorna una lista con los Addons
     */
    public List<IAddon> getAddons() {
        File[] allFiles = getAllfilesAddons();
        List<IAddon> lstOut = new ArrayList<>();
        if (null != allFiles) {
            try {
                for (File aFile : allFiles) {
                    try {
                        Attributes attrs = new JarFile(aFile).getManifest().getMainAttributes();
                        if (null != attrs) {
                            if (null != attrs.getValue(MANIFEST_ATTRIB)) {
                                ClassLoader loader
                                        = URLClassLoader.newInstance(new URL[]{aFile.toURI().
                                    toURL()}, Addons.class.getClassLoader());
                                Class<?> clase = Class.forName(attrs.getValue(MANIFEST_ATTRIB), true, loader);
                                lstOut.add((IAddon) clase.getDeclaredConstructor().newInstance());
                            }
                        }
                    } catch (IOException ex) {
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lstOut;
    }
}
