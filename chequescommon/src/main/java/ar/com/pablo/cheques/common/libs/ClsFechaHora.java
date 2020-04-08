package ar.com.pablo.cheques.common.libs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Descripción: Clase para manejo de fechas y horas
 *
 * @author Pablo M.
 * @version 1.0 Fecha: 04/05/2010
 */
public class ClsFechaHora {

    EDiasDeLaSemana primerDiaDeLaSemana = EDiasDeLaSemana.Lunes;

    /**
     * Constructor por defecto Se toma como primer dia de la semaman
     * <b>Lunes</b>
     */
    public ClsFechaHora() {
    }

    /**
     * Constructor 2
     *
     * @param primerDiaDeLaSemana especifica cual es el primer dia de la semana
     */
    public ClsFechaHora(EDiasDeLaSemana primerDiaDeLaSemana) {
        this.primerDiaDeLaSemana = primerDiaDeLaSemana;
    }

    /**
     * Devuelve el <b>día actual</b>
     *
     * @return Integer con el día actual
     */
    public Integer getDia() {
        Calendar objCal = new GregorianCalendar();
        return objCal.get(Calendar.DATE);
    }

    /**
     * Devuelve el <b>día actual</b>
     *
     * @return Integer con el día de la fecha pasada
     */
    public Integer getDia(Date fecha) {
        Calendar objCal = new GregorianCalendar();
        objCal.setTime(fecha);
        return objCal.get(Calendar.DATE);
    }

    /**
     * Devuelve el <b>mes actual</b>
     *
     * @return Integer con el mes actual
     */
    public Integer getMes() {
        Calendar objCal = new GregorianCalendar();
        return objCal.get(Calendar.MONTH) + 1;
    }

    /**
     * Devuelve el <b>mes actual</b>
     *
     * @return Integer con el mes actual de la fecha pasada
     */
    public Integer getMes(Date fecha) {
        Calendar objCal = new GregorianCalendar();
        objCal.setTime(fecha);
        return objCal.get(Calendar.MONTH) + 1;
    }

    /**
     * Devuelve al <b>año actual</b>
     *
     * @return Integer con el año actual
     */
    public Integer getAnio() {
        Calendar objCal = new GregorianCalendar();
        return objCal.get(Calendar.YEAR);
    }

    /**
     * Devuelve al <b>año actual</b>
     *
     * @return Integer con el año actual de la fecha pasada
     */
    public Integer getAnio(Date fecha) {
        Calendar objCal = new GregorianCalendar();
        objCal.setTime(fecha);
        return objCal.get(Calendar.YEAR);
    }

    /**
     * Devuelve un fecha en base a un patrón
     *
     * <table style="width: 100%;" border="0" cellpadding="0">
     * <tbody><tr>
     * <td><strong>Símbolo</strong></td>
     * <td><strong>Significado</strong></td>
     * <td><strong>Tipo</strong></td>
     * <td><strong>Ejemplo</strong></td>
     * </tr>
     * <tr><td>G</td><td>Era</td><td>Text</td><td>“GG” -&gt; “AD”</td></tr>
     * <tr><td>y</td><td>Year</td><td>Number</td><td>“yy” -&gt; “03?<br />“yyyy”
     * -&gt; “2003?</td></tr>
     * <tr><td>M</td><td>Month</td><td>Text or Number</td><td>“M” -&gt;
     * “7?<br />“M” -&gt; “12?<br />“MM” -&gt; “07?<br />“MMM” -&gt;
     * “Jul”<br />“MMMM” -&gt; “December”</td></tr>
     * <tr><td>d</td><td>Day in month</td><td>Number</td><td>“d” -&gt;
     * “3?<br />“dd” -&gt; “03?</td></tr>
     * <tr><td>h</td><td>Hour (1-12, AM/PM)</td><td>Number</td><td>“h” -&gt;
     * “3?<br />“hh” -&gt; “03?</td></tr>
     * <tr><td>H</td><td>Hour (0-23)</td><td>Number</td><td>“H” -&gt;
     * “15?<br />“HH” -&gt; “15?</td></tr>
     * <tr><td>k</td><td>Hour (1-24)</td><td>Number</td><td>“k” -&gt;
     * “3?<br />“kk” -&gt; “03?</td></tr>
     * <tr><td>K</td><td>Hour (0-11 AM/PM)</td><td>Number</td><td>“K” -&gt;
     * “15?<br />“KK” -&gt; “15?</td></tr>
     * <tr><td>m</td><td>Minute</td><td>Number</td><td>“m” -&gt; “7?<br />“m”
     * -&gt; “15?<br />“mm” -&gt; “15?</td></tr>
     * <tr><td>s</td><td>Second</td><td>Number</td><td>“s” -&gt; “15?<br />“ss”
     * -&gt; “15?</td></tr>
     * <tr><td>S</td><td>Millisecond (0-999)</td><td>Number</td><td>“SSS” -&gt;
     * “007?</td></tr>
     * <tr><td>E</td><td>Day in week</td><td>Text</td><td>“EEE” -&gt;
     * “Tue”<br />“EEEE” -&gt; “Tuesday”</td></tr>
     * <tr><td>D</td><td>Day in year (1-365 or 1-364)</td><td>Number</td><td>“D”
     * -&gt; “65?<br />“DDD” -&gt; “065?</td></tr>
     * <tr><td>F</td><td>Day of week in month (1-5)</td><td>Number</td><td>“F”
     * -&gt; “1?</td></tr>
     * <tr><td>w</td><td>Week in year (1-53)</td><td>Number</td><td>“w” -&gt;
     * “7?</td></tr>
     * <tr><td>W</td><td>Week in month (1-5)</td><td>Number</td><td>“W” -&gt;
     * “3?</td></tr>
     * <tr><td>a</td><td>AM/PM</td><td>Text</td><td>“a” -&gt; “AM”<br />“aa”
     * -&gt; “AM”</td></tr>
     * <tr><td>z</td><td>Time zone</td><td>Text</td><td>“z” -&gt;
     * “EST”<br />“zzz” -&gt; “EST”<br />“zzzz” -&gt; “Eastern Standard
     * Time”</td></tr>
     * <tr><td>‘</td><td>Excape for text</td><td>Delimiter</td><td>“‘hour’ h”
     * -&gt; “hour 9?</td></tr>
     * <tr><td>”</td><td>Single quote</td><td>Literal</td><td>“ss”SSS” -&gt;
     * “45’876?</td></tr>
     * <tr><td>Symbol</td><td>Meaning</td><td>Type</td><td>Example</td></tr>
     * <tr><td>G</td><td>Era</td><td>Text</td><td>“GG” -&gt; “AD”</td></tr>
     * <tr><td>y</td><td>Year</td><td>Number</td><td>“yy” -&gt; “03?<br />“yyyy”
     * -&gt; “2003?</td></tr>
     * <tr><td>M</td><td>Month</td><td>Text or Number</td><td>“M” -&gt;
     * “7?<br />“M” -&gt; “12?<br />“MM” -&gt; “07?<br />“MMM” -&gt;
     * “Jul”<br />“MMMM” -&gt; “December”</td></tr>
     * <tr><td>d</td><td>Day in month</td><td>Number</td><td>“d” -&gt;
     * “3?<br />“dd” -&gt; “03?</td></tr>
     * <tr><td>h</td><td>Hour (1-12, AM/PM)</td><td>Number</td><td>“h” -&gt;
     * “3?<br />“hh” -&gt; “03?</td></tr>
     * <tr><td>H</td><td>Hour (0-23)</td><td>Number</td><td>“H” -&gt;
     * “15?<br />“HH” -&gt; “15?</td></tr>
     * <tr><td>k</td><td>Hour (1-24)</td><td>Number</td><td>“k” -&gt;
     * “3?<br />“kk” -&gt; “03?</td></tr>
     * <tr><td>K</td><td>Hour (0-11 AM/PM)</td><td>Number</td><td>“K” -&gt;
     * “15?<br />“KK” -&gt; “15?</td></tr><tr><td>m</td>
     * <td>Minute</td><td>Number</td><td>“m” -&gt; “7?<br />“m” -&gt;
     * “15?<br />“mm” -&gt; “15?</td></tr>
     * <tr><td>s</td><td>Second</td><td>Number</td><td>“s” -&gt; “15?<br />“ss”
     * -&gt; “15?</td></tr>
     * <tr><td>S</td><td>Millisecond (0-999)</td><td>Number</td><td>“SSS” -&gt;
     * “007?</td></tr>
     * <tr><td>E</td><td>Day in week</td><td>Text</td><td>“EEE” -&gt;
     * “Tue”<br />“EEEE” -&gt; “Tuesday”</td></tr>
     * <tr><td>D</td><td>Day in year (1-365 or 1-364)</td><td>Number</td><td>“D”
     * -&gt; “65?<br />“DDD” -&gt; “065?</td></tr>
     * <tr><td>F</td><td>Day of week in month (1-5)</td><td>Number</td><td>“F”
     * -&gt; “1?</td></tr>
     * <tr><td>w</td><td>Week in year (1-53)</td><td>Number</td><td>“w” -&gt;
     * “7?</td></tr>
     * <tr><td>W</td><td>Week in month (1-5)</td><td>Number</td>
     * <td>“W” -&gt;
     * “3?</td></tr><tr><td>a</td><td>AM/PM</td><td>Text</td><td>“a” -&gt;
     * “AM”<br />“aa” -&gt; “AM”</td></tr>
     * <tr><td>z</td><td>Time zone</td><td>Text</td><td>“z” -&gt;
     * “EST”<br />“zzz” -&gt; “EST”<br />“zzzz” -&gt; “Eastern Standard
     * Time”</td></tr>
     * <td>Delimiter</td><td>“‘hour’ h” -&gt; “hour 9?</td></tr>
     * <tr><td>”</td><td>Single quote</td><td>Literal</td><td>“ss”SSS” -&gt;
     * “45’876?</td></tr>
     * </tbody></table>
     *
     * @param formato patrón con el formato de salida
     * @return String con la fecha formateada
     * @see getDateTimeFormat(Date fecha,String formato)
     */
    public String getDateTimeFormat(String formato) {
        DateFormat dateFormat = new SimpleDateFormat(formato);
        Date tempFecha = new Date();
        return dateFormat.format(tempFecha);
    }

    /**
     * Devuelve un fecha en base a un patrón
     *
     * <table style="width: 100%;" border="0" cellpadding="0">
     * <tbody><tr>
     * <td><strong>Símbolo</strong></td>
     * <td><strong>Significado</strong></td>
     * <td><strong>Tipo</strong></td>
     * <td><strong>Ejemplo</strong></td>
     * </tr>
     * <tr><td>G</td><td>Era</td><td>Text</td><td>“GG” -&gt; “AD”</td></tr>
     * <tr><td>y</td><td>Year</td><td>Number</td><td>“yy” -&gt; “03?<br />“yyyy”
     * -&gt; “2003?</td></tr>
     * <tr><td>M</td><td>Month</td><td>Text or Number</td><td>“M” -&gt;
     * “7?<br />“M” -&gt; “12?<br />“MM” -&gt; “07?<br />“MMM” -&gt;
     * “Jul”<br />“MMMM” -&gt; “December”</td></tr>
     * <tr><td>d</td><td>Day in month</td><td>Number</td><td>“d” -&gt;
     * “3?<br />“dd” -&gt; “03?</td></tr>
     * <tr><td>h</td><td>Hour (1-12, AM/PM)</td><td>Number</td><td>“h” -&gt;
     * “3?<br />“hh” -&gt; “03?</td></tr>
     * <tr><td>H</td><td>Hour (0-23)</td><td>Number</td><td>“H” -&gt;
     * “15?<br />“HH” -&gt; “15?</td></tr>
     * <tr><td>k</td><td>Hour (1-24)</td><td>Number</td><td>“k” -&gt;
     * “3?<br />“kk” -&gt; “03?</td></tr>
     * <tr><td>K</td><td>Hour (0-11 AM/PM)</td><td>Number</td><td>“K” -&gt;
     * “15?<br />“KK” -&gt; “15?</td></tr>
     * <tr><td>m</td><td>Minute</td><td>Number</td><td>“m” -&gt; “7?<br />“m”
     * -&gt; “15?<br />“mm” -&gt; “15?</td></tr>
     * <tr><td>s</td><td>Second</td><td>Number</td><td>“s” -&gt; “15?<br />“ss”
     * -&gt; “15?</td></tr>
     * <tr><td>S</td><td>Millisecond (0-999)</td><td>Number</td><td>“SSS” -&gt;
     * “007?</td></tr>
     * <tr><td>E</td><td>Day in week</td><td>Text</td><td>“EEE” -&gt;
     * “Tue”<br />“EEEE” -&gt; “Tuesday”</td></tr>
     * <tr><td>D</td><td>Day in year (1-365 or 1-364)</td><td>Number</td><td>“D”
     * -&gt; “65?<br />“DDD” -&gt; “065?</td></tr>
     * <tr><td>F</td><td>Day of week in month (1-5)</td><td>Number</td><td>“F”
     * -&gt; “1?</td></tr>
     * <tr><td>w</td><td>Week in year (1-53)</td><td>Number</td><td>“w” -&gt;
     * “7?</td></tr>
     * <tr><td>W</td><td>Week in month (1-5)</td><td>Number</td><td>“W” -&gt;
     * “3?</td></tr>
     * <tr><td>a</td><td>AM/PM</td><td>Text</td><td>“a” -&gt; “AM”<br />“aa”
     * -&gt; “AM”</td></tr>
     * <tr><td>z</td><td>Time zone</td><td>Text</td><td>“z” -&gt;
     * “EST”<br />“zzz” -&gt; “EST”<br />“zzzz” -&gt; “Eastern Standard
     * Time”</td></tr>
     * <tr><td>‘</td><td>Excape for text</td><td>Delimiter</td><td>“‘hour’ h”
     * -&gt; “hour 9?</td></tr>
     * <tr><td>”</td><td>Single quote</td><td>Literal</td><td>“ss”SSS” -&gt;
     * “45’876?</td></tr>
     * <tr><td>Symbol</td><td>Meaning</td><td>Type</td><td>Example</td></tr>
     * <tr><td>G</td><td>Era</td><td>Text</td><td>“GG” -&gt; “AD”</td></tr>
     * <tr><td>y</td><td>Year</td><td>Number</td><td>“yy” -&gt; “03?<br />“yyyy”
     * -&gt; “2003?</td></tr>
     * <tr><td>M</td><td>Month</td><td>Text or Number</td><td>“M” -&gt;
     * “7?<br />“M” -&gt; “12?<br />“MM” -&gt; “07?<br />“MMM” -&gt;
     * “Jul”<br />“MMMM” -&gt; “December”</td></tr>
     * <tr><td>d</td><td>Day in month</td><td>Number</td><td>“d” -&gt;
     * “3?<br />“dd” -&gt; “03?</td></tr>
     * <tr><td>h</td><td>Hour (1-12, AM/PM)</td><td>Number</td><td>“h” -&gt;
     * “3?<br />“hh” -&gt; “03?</td></tr>
     * <tr><td>H</td><td>Hour (0-23)</td><td>Number</td><td>“H” -&gt;
     * “15?<br />“HH” -&gt; “15?</td></tr>
     * <tr><td>k</td><td>Hour (1-24)</td><td>Number</td><td>“k” -&gt;
     * “3?<br />“kk” -&gt; “03?</td></tr>
     * <tr><td>K</td><td>Hour (0-11 AM/PM)</td><td>Number</td><td>“K” -&gt;
     * “15?<br />“KK” -&gt; “15?</td></tr><tr><td>m</td>
     * <td>Minute</td><td>Number</td><td>“m” -&gt; “7?<br />“m” -&gt;
     * “15?<br />“mm” -&gt; “15?</td></tr>
     * <tr><td>s</td><td>Second</td><td>Number</td><td>“s” -&gt; “15?<br />“ss”
     * -&gt; “15?</td></tr>
     * <tr><td>S</td><td>Millisecond (0-999)</td><td>Number</td><td>“SSS” -&gt;
     * “007?</td></tr>
     * <tr><td>E</td><td>Day in week</td><td>Text</td><td>“EEE” -&gt;
     * “Tue”<br />“EEEE” -&gt; “Tuesday”</td></tr>
     * <tr><td>D</td><td>Day in year (1-365 or 1-364)</td><td>Number</td><td>“D”
     * -&gt; “65?<br />“DDD” -&gt; “065?</td></tr>
     * <tr><td>F</td><td>Day of week in month (1-5)</td><td>Number</td><td>“F”
     * -&gt; “1?</td></tr>
     * <tr><td>w</td><td>Week in year (1-53)</td><td>Number</td><td>“w” -&gt;
     * “7?</td></tr>
     * <tr><td>W</td><td>Week in month (1-5)</td><td>Number</td>
     * <td>“W” -&gt;
     * “3?</td></tr><tr><td>a</td><td>AM/PM</td><td>Text</td><td>“a” -&gt;
     * “AM”<br />“aa” -&gt; “AM”</td></tr>
     * <tr><td>z</td><td>Time zone</td><td>Text</td><td>“z” -&gt;
     * “EST”<br />“zzz” -&gt; “EST”<br />“zzzz” -&gt; “Eastern Standard
     * Time”</td></tr>
     * <td>Delimiter</td><td>“‘hour’ h” -&gt; “hour 9?</td></tr>
     * <tr><td>”</td><td>Single quote</td><td>Literal</td><td>“ss”SSS” -&gt;
     * “45’876?</td></tr>
     * </tbody></table>
     *
     * @param fecha Fecha a parsear
     * @param formato patrón con el formato de salida
     * @return String con la fecha formateada
     * @see getDateTimeFormat(String formato)
     */
    public String getDateTimeFormat(Date fecha, String formato) {
        if (null != fecha && null != formato) {
            DateFormat dateFormat = new SimpleDateFormat(formato);
            return dateFormat.format(fecha);
        } else {
            return null;
        }
    }

    /**
     * Convierte un String a un date
     *
     * <table style="width: 100%;" border="0" cellpadding="0">
     * <tbody><tr>
     * <td><strong>Símbolo</strong></td>
     * <td><strong>Significado</strong></td>
     * <td><strong>Tipo</strong></td>
     * <td><strong>Ejemplo</strong></td>
     * </tr>
     * <tr><td>G</td><td>Era</td><td>Text</td><td>“GG” -&gt; “AD”</td></tr>
     * <tr><td>y</td><td>Year</td><td>Number</td><td>“yy” -&gt; “03?<br />“yyyy”
     * -&gt; “2003?</td></tr>
     * <tr><td>M</td><td>Month</td><td>Text or Number</td><td>“M” -&gt;
     * “7?<br />“M” -&gt; “12?<br />“MM” -&gt; “07?<br />“MMM” -&gt;
     * “Jul”<br />“MMMM” -&gt; “December”</td></tr>
     * <tr><td>d</td><td>Day in month</td><td>Number</td><td>“d” -&gt;
     * “3?<br />“dd” -&gt; “03?</td></tr>
     * <tr><td>h</td><td>Hour (1-12, AM/PM)</td><td>Number</td><td>“h” -&gt;
     * “3?<br />“hh” -&gt; “03?</td></tr>
     * <tr><td>H</td><td>Hour (0-23)</td><td>Number</td><td>“H” -&gt;
     * “15?<br />“HH” -&gt; “15?</td></tr>
     * <tr><td>k</td><td>Hour (1-24)</td><td>Number</td><td>“k” -&gt;
     * “3?<br />“kk” -&gt; “03?</td></tr>
     * <tr><td>K</td><td>Hour (0-11 AM/PM)</td><td>Number</td><td>“K” -&gt;
     * “15?<br />“KK” -&gt; “15?</td></tr>
     * <tr><td>m</td><td>Minute</td><td>Number</td><td>“m” -&gt; “7?<br />“m”
     * -&gt; “15?<br />“mm” -&gt; “15?</td></tr>
     * <tr><td>s</td><td>Second</td><td>Number</td><td>“s” -&gt; “15?<br />“ss”
     * -&gt; “15?</td></tr>
     * <tr><td>S</td><td>Millisecond (0-999)</td><td>Number</td><td>“SSS” -&gt;
     * “007?</td></tr>
     * <tr><td>E</td><td>Day in week</td><td>Text</td><td>“EEE” -&gt;
     * “Tue”<br />“EEEE” -&gt; “Tuesday”</td></tr>
     * <tr><td>D</td><td>Day in year (1-365 or 1-364)</td><td>Number</td><td>“D”
     * -&gt; “65?<br />“DDD” -&gt; “065?</td></tr>
     * <tr><td>F</td><td>Day of week in month (1-5)</td><td>Number</td><td>“F”
     * -&gt; “1?</td></tr>
     * <tr><td>w</td><td>Week in year (1-53)</td><td>Number</td><td>“w” -&gt;
     * “7?</td></tr>
     * <tr><td>W</td><td>Week in month (1-5)</td><td>Number</td><td>“W” -&gt;
     * “3?</td></tr>
     * <tr><td>a</td><td>AM/PM</td><td>Text</td><td>“a” -&gt; “AM”<br />“aa”
     * -&gt; “AM”</td></tr>
     * <tr><td>z</td><td>Time zone</td><td>Text</td><td>“z” -&gt;
     * “EST”<br />“zzz” -&gt; “EST”<br />“zzzz” -&gt; “Eastern Standard
     * Time”</td></tr>
     * <tr><td>‘</td><td>Excape for text</td><td>Delimiter</td><td>“‘hour’ h”
     * -&gt; “hour 9?</td></tr>
     * <tr><td>”</td><td>Single quote</td><td>Literal</td><td>“ss”SSS” -&gt;
     * “45’876?</td></tr>
     * <tr><td>Symbol</td><td>Meaning</td><td>Type</td><td>Example</td></tr>
     * <tr><td>G</td><td>Era</td><td>Text</td><td>“GG” -&gt; “AD”</td></tr>
     * <tr><td>y</td><td>Year</td><td>Number</td><td>“yy” -&gt; “03?<br />“yyyy”
     * -&gt; “2003?</td></tr>
     * <tr><td>M</td><td>Month</td><td>Text or Number</td><td>“M” -&gt;
     * “7?<br />“M” -&gt; “12?<br />“MM” -&gt; “07?<br />“MMM” -&gt;
     * “Jul”<br />“MMMM” -&gt; “December”</td></tr>
     * <tr><td>d</td><td>Day in month</td><td>Number</td><td>“d” -&gt;
     * “3?<br />“dd” -&gt; “03?</td></tr>
     * <tr><td>h</td><td>Hour (1-12, AM/PM)</td><td>Number</td><td>“h” -&gt;
     * “3?<br />“hh” -&gt; “03?</td></tr>
     * <tr><td>H</td><td>Hour (0-23)</td><td>Number</td><td>“H” -&gt;
     * “15?<br />“HH” -&gt; “15?</td></tr>
     * <tr><td>k</td><td>Hour (1-24)</td><td>Number</td><td>“k” -&gt;
     * “3?<br />“kk” -&gt; “03?</td></tr>
     * <tr><td>K</td><td>Hour (0-11 AM/PM)</td><td>Number</td><td>“K” -&gt;
     * “15?<br />“KK” -&gt; “15?</td></tr><tr><td>m</td>
     * <td>Minute</td><td>Number</td><td>“m” -&gt; “7?<br />“m” -&gt;
     * “15?<br />“mm” -&gt; “15?</td></tr>
     * <tr><td>s</td><td>Second</td><td>Number</td><td>“s” -&gt; “15?<br />“ss”
     * -&gt; “15?</td></tr>
     * <tr><td>S</td><td>Millisecond (0-999)</td><td>Number</td><td>“SSS” -&gt;
     * “007?</td></tr>
     * <tr><td>E</td><td>Day in week</td><td>Text</td><td>“EEE” -&gt;
     * “Tue”<br />“EEEE” -&gt; “Tuesday”</td></tr>
     * <tr><td>D</td><td>Day in year (1-365 or 1-364)</td><td>Number</td><td>“D”
     * -&gt; “65?<br />“DDD” -&gt; “065?</td></tr>
     * <tr><td>F</td><td>Day of week in month (1-5)</td><td>Number</td><td>“F”
     * -&gt; “1?</td></tr>
     * <tr><td>w</td><td>Week in year (1-53)</td><td>Number</td><td>“w” -&gt;
     * “7?</td></tr>
     * <tr><td>W</td><td>Week in month (1-5)</td><td>Number</td>
     * <td>“W” -&gt;
     * “3?</td></tr><tr><td>a</td><td>AM/PM</td><td>Text</td><td>“a” -&gt;
     * “AM”<br />“aa” -&gt; “AM”</td></tr>
     * <tr><td>z</td><td>Time zone</td><td>Text</td><td>“z” -&gt;
     * “EST”<br />“zzz” -&gt; “EST”<br />“zzzz” -&gt; “Eastern Standard
     * Time”</td></tr>
     * <td>Delimiter</td><td>“‘hour’ h” -&gt; “hour 9?</td></tr>
     * <tr><td>”</td><td>Single quote</td><td>Literal</td><td>“ss”SSS” -&gt;
     * “45’876?</td></tr>
     * </tbody></table>
     *
     * @param date fecha
     * @param formato patron
     * @return objeto Date
     * @see getDateTimeFormat(String formato)
     * @see getDateTimeFormat(Date fecha,String formato)
     */
    public Date getDate(String date, String formato) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato);
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(date);
        } catch (ParseException ex) {
        }
        formatoDelTexto = null;
        return fecha;
    }

    /**
     * Valida una fecha en base a un patrón
     *
     * Ejemplo: Patrón: yyyyMMdd Fecha: <b>19990202</b>   <i>--Corecto--</i>
     * Fecha: <b>19990230</b>   <i>--incoorecto--</i>
     * Fecha: <b>19990229</b>   <i>--Incorrecto--</i>
     * Fecha: <b>30-12-2002</b> <i>--Corecto--</i>
     *
     * @param fecha fecha a validar
     * @param patrón mascar para comparar la fecha ingresada
     * @return boolena si la fecha es válida o no
     */
    public boolean validarFecha(String fecha, String patron) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(patron);
            sdf.setLenient(false);
            Date dt2 = sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Convierte un <b>String</b> a un <b>Date</b>
     *
     * @param fecha fecha a parsear
     * @param formato formato en que se encuentra la fecha ej: dd-MM-yyyy
     * @return Date con la fecha parseada
     */
    public Date parseString(String fecha, String formato) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato);
        try {
            return formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * Retorna la diferencia de dos fechas <b>en segundos</b>
     *
     * @param fechaStar Fecha de inicio
     * @param fechaEnd Fecha final
     * @return diferencia en segundos de fechaStart y fechaEnd
     */
    public long getTimeDiff(Date fechaStar, Date fechaEnd) {
        if (fechaStar == null || fechaEnd == null) {
            return 0;
        }

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.set(Integer.parseInt(getDateTimeFormat(fechaStar, "yyyy")),
                Integer.parseInt(getDateTimeFormat(fechaStar, "MM")),
                Integer.parseInt(getDateTimeFormat(fechaStar, "dd")),
                Integer.parseInt(getDateTimeFormat(fechaStar, "kk")),
                Integer.parseInt(getDateTimeFormat(fechaStar, "mm")),
                Integer.parseInt(getDateTimeFormat(fechaStar, "ss")));

        cal2.set(Integer.parseInt(getDateTimeFormat(fechaEnd, "yyyy")),
                Integer.parseInt(getDateTimeFormat(fechaEnd, "MM")),
                Integer.parseInt(getDateTimeFormat(fechaEnd, "dd")),
                Integer.parseInt(getDateTimeFormat(fechaEnd, "kk")),
                Integer.parseInt(getDateTimeFormat(fechaEnd, "mm")),
                Integer.parseInt(getDateTimeFormat(fechaEnd, "ss")));

        long milis1 = cal1.getTimeInMillis() / 1000;
        long milis2 = cal2.getTimeInMillis() / 1000;

        long diff = milis2 - milis1;
        cal1 = null;
        cal2 = null;

        return diff;

    }

    /**
     * Retorna el nombre del dia de la semana que es
     *
     * @param fecha fecha a consultar
     * @return Enumeracion con el dia de la semana que es
     */
    public EDiasDeLaSemana GetQueDiaDeLaSemanaEs(Date fecha) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);

        switch (cal.get(Calendar.DAY_OF_WEEK) - 1) {
            case 0:
                return EDiasDeLaSemana.Domingo;
            case 1:
                return EDiasDeLaSemana.Lunes;
            case 2:
                return EDiasDeLaSemana.Martes;
            case 3:
                return EDiasDeLaSemana.Miercoles;
            case 4:
                return EDiasDeLaSemana.Jueves;
            case 5:
                return EDiasDeLaSemana.Viernes;
            default:
                return EDiasDeLaSemana.Sabado;
        }
    }

    /**
     * Retorna una fecha con el dia de la semana en el cual se encuentra la
     * fecha dada
     *
     * @param fecha fecha a consultar
     * @param diaDeLaSemana Enumeracion con el dia de la semana que se desea
     * consultar
     * @return fecha del dia consultado
     */
    public Date getDiaDelaSemana(Date fecha, EDiasDeLaSemana diaDeLaSemana) {
        Calendar cal = new GregorianCalendar();
        setPrimerDiaDeLaSemana(cal);
        cal.set(Calendar.DAY_OF_WEEK, getDayOfWeek(diaDeLaSemana));

        return cal.getTime();
    }

    /**
     * Retorna el ultimo dia de un mes a partir de una fecha
     *
     * @param fecha fecha del mes a consultar
     * @return el ultimo dia del mes
     */
    public Date getLastDayOfTheMonth(Date fecha) {
        String elMes = getDateTimeFormat(fecha, "MM");
        String elAnio = getDateTimeFormat(fecha, "yyyy");
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);

        return parseString(String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH))
                + "-" + elMes + "-" + elAnio,
                "dd-MM-yyyy");
    }

    /**
     * Retorna el primer dia de un mes a partir de una fecha
     *
     * @param fecha fecha del mes a consultar
     * @return el primer dia del mes
     */
    public Date getFirstDayOfTheMonth(Date fecha) {
        String elMes = getDateTimeFormat(fecha, "MM");
        String elAnio = getDateTimeFormat(fecha, "yyyy");

        return parseString("01" + "-" + elMes + "-" + elAnio, "dd-MM-yyyy");
    }

    private void setPrimerDiaDeLaSemana(Calendar objCalendar) {
        switch (primerDiaDeLaSemana) {
            case Domingo:
                objCalendar.setFirstDayOfWeek(Calendar.SUNDAY);
                break;
            case Lunes:
                objCalendar.setFirstDayOfWeek(Calendar.MONDAY);
                break;
            case Martes:
                objCalendar.setFirstDayOfWeek(Calendar.TUESDAY);
                break;
            case Miercoles:
                objCalendar.setFirstDayOfWeek(Calendar.WEDNESDAY);
                break;
            case Jueves:
                objCalendar.setFirstDayOfWeek(Calendar.THURSDAY);
                break;
            case Viernes:
                objCalendar.setFirstDayOfWeek(Calendar.FRIDAY);
                break;
            default:
                objCalendar.setFirstDayOfWeek(Calendar.SATURDAY);
                break;
        }
    }

    private int getDayOfWeek(EDiasDeLaSemana diaDeLaSemana) {
        switch (diaDeLaSemana) {
            case Domingo:
                return Calendar.SUNDAY;
            case Lunes:
                return Calendar.MONDAY;
            case Martes:
                return Calendar.TUESDAY;
            case Miercoles:
                return Calendar.WEDNESDAY;
            case Jueves:
                return Calendar.THURSDAY;
            case Viernes:
                return Calendar.FRIDAY;
            default:
                return Calendar.SATURDAY;
        }
    }

    /**
     * Comprueba si una hora está dentro de un rango determinado
     *
     * @param rangoInicio Hora de inicio del rango
     * @param rangoFinal Hora final del rango
     * @param horaAValidar Hora a validar
     * @return True=Esta dentro del Rango dado - False=no los está
     */
    public boolean isEstaEnElRango(Date rangoInicio, Date rangoFinal, Date horaAValidar) {
        return horaAValidar.after(rangoInicio) && horaAValidar.before(rangoFinal);
    }
}
