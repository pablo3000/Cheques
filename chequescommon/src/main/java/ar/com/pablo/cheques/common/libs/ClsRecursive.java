package ar.com.pablo.cheques.common.libs;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Descripción: Lista el contenido de un directorio de forma recursiva, de tal
 * forma que vayamos conociendo el contenido de sus directorios anidados.
 * @author Pablo M.
 * @version 1.0 Fecha: 12-nov-2010
 */
public class ClsRecursive {

    /**
     * Lista en forma recursiva todos los directorios hijos a partir de un
     * directorio padre
     *
     * @param dir <b>String</b> con el <b>directorio de padre</b>
     * @return Array de String
     */
    public String[] getListDir(String dir) {
        return getListDir(new File(dir), java.io.File.separator);
    }

    /**
     * Lista en forma recursiva todos los directorios hijos a partir de un
     * directorio padre
     *
     * @param dir <b>File</b> con el <b>directorio de padre</b>
     * @return Array de String
     */
    public String[] getListDir(File dir) {
        return getListDir(dir, java.io.File.separator);
    }

    /**
     * Lista en forma recursiva todos los directorios hijos a partir de un
     * directorio padre
     *
     * @param dir <b>String</b> con el <b>directorio de padre</b>
     * @param separador <b>String</b> con el <b>separador de archivos</b>
     * @return Array de String
     */
    public String[] getListDir(String dir, String separador) {
        return getListDir(new File(dir), separador);
    }

    /**
     * Lista en forma recursiva todos los directorios hijos a partir de un
     * directorio padre
     *
     * @param dir <b>File</b> con el <b>directorio de padre</b>
     * @param separador <b>String</b> con el <b>separador de archivos</b>
     * @return Array de String
     */
    public String[] getListDir(File dir, String separador) {
        List<File> tempDIR = getFileListing(dir, separador);
        tempDIR.add(dir);
        String[] tempArrayDIR = new String[tempDIR.size()];
        int cont = 0;

        for (File file : tempDIR) {
            tempArrayDIR[cont] = file.getPath();
            cont++;
        }
        return tempArrayDIR;
    }

    private List<File> getFileListing(File dir, String separador) {
        List<File> result = new ArrayList<>();
        File[] filesAndDirs = dir.listFiles();
        List<File> filesDirs = Arrays.asList(filesAndDirs);

        filesDirs.stream().filter((file) -> (file.isDirectory())).map((file) -> {
            result.add(file);
            return file;
        }).map((file) -> getFileListing(file, separador)).forEachOrdered((deeperList) -> {
            result.addAll(deeperList);
        });
        return result;
    }

    /**
     * Retorna los archivos recursivos contenidos en un directorio
     *
     * @param dir directorio con el contenido de los archivos
     * @param filtro filtro
     * @return
     */
    public File[] getFileListing(String dir, FilenameFilter filtro) {
        ClsRecursive objRE = new ClsRecursive();
        ArrayList<File> vUrls = new ArrayList<>();
        String[] tempDIRs = objRE.getListDir(dir);

        for (String tempDIR : tempDIRs) {
            File directorio = new File(tempDIR);
            if (directorio.exists() && directorio.isDirectory()) {
                File[] jars = directorio.listFiles(filtro);
                vUrls.addAll(Arrays.asList(jars));
            }
        }
        objRE = null;
        return vUrls.toArray(new File[0]);
    }
}
