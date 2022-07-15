
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/**
 *
 * @author joao.sintra
 */
public class Ferias {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("testeferias7.csv");

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            BufferedWriter writer = new BufferedWriter(new FileWriter("feriasFinal.txt"));

            while ((nextRecord = csvReader.readNext()) != null) {

                //System.out.println();
                String idUser = "" + nextRecord[0];
                int tamanho = nextRecord[0].length();
                do {
                    idUser = "0" + idUser;
                    tamanho++;
                } while (tamanho < 5);

                System.out.println(idUser);
//                System.out.println(newDateString+"--" + nextRecord[1]);
                writer.write(idUser + "as" + "\n");

            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        DateTimeFormatter caseInsensitiveDtf = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yy").toFormatter(Locale.UK);
        LocalDate localDate = LocalDate.parse("28-Mar-22", caseInsensitiveDtf);
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
        String dataFerias01 = myFormat.format(fromUser.parse(localDate.toString()));

        System.out.println(dataFerias01);

    }
}
