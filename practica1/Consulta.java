import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.*;
import java.util.Collections;

public class Consulta {
    
        public Boolean lt200p(CsvReader csv) throws IOException{
            int sqrmts = Integer.parseInt(csv.get("Metros Cuadrados Propiedad"));
            double vp = Double.parseDouble(csv.get("Valor Propiedad"));
            if (sqrmts < 200 && vp <= 500000.0 && vp >= 50000.00 ) {
              return true;
            }
            return false;
        }


        public static void main(String[] args) throws IOException{

          Consulta consultin = new Consulta();
          List prices = new ArrayList();
          List marta = new ArrayList();
          List<Cliente> margen = new ArrayList<Cliente>();
          int counter = 0;

          CsvReader mi_csv = new CsvReader("P1.csv");
          mi_csv.readHeaders();

          while (mi_csv.readRecord()){
            if(consultin.lt200p(mi_csv)){
              counter += 1;
            }

            String name = mi_csv.get("Nombre");
            String phone = mi_csv.get("Telefono");
            String address = mi_csv.get("Direccion");
            String mail = mi_csv.get("Correo");
            int sqrmts = Integer.parseInt(mi_csv.get("Metros Cuadrados Propiedad"));
            double pvalue = Double.parseDouble(mi_csv.get("Valor Propiedad"));
            double svalue = Double.parseDouble(mi_csv.get("Valor de Venta"));
            double marg = svalue - pvalue;

            Cliente client = new Cliente(name,phone,address,mail,sqrmts,pvalue,svalue);
            client.setMargen(marg);
            marta.add(marg);


            prices.add(pvalue);
            margen.add(client);
          }
          
          System.out.println("\nPropiedades con menos de 200m2 y valen entre $50,000 y $500,000:\n"+counter+"\n");

          Collections.sort(prices);
          System.out.println("Las 10 propiedades más baratas.");
          for (int i = 0; i < 10 ;i++ ) {
          	System.out.println(prices.get(i));
          }

          System.out.println("\nLas 5 propiedades más caras.");
          for (int i = prices.size() -1; i > prices.size() - 6 ; i-- ) {
          	System.out.println(prices.get(i));
          }

          Collections.sort(marta);
          System.out.println("\nLas 5 propiedades con mayor margen de ganancia.");
          for (int l = 0; l<margen.size() ; l++ ) {
            for (int i = marta.size()-1; i > marta.size() -6 ; i-- ) {
              if(margen.get(l).findPropertyMarg((double)marta.get(i)) != null){
              	System.out.println(margen.get(l).findPropertyMarg((double)marta.get(i)));
              }
            }
          }

          System.out.println("\nNombre y correo de las 5 personas con mayor margen de ganancia.");
          for (int l = 0; l<margen.size() ; l++ ) {
            for (int i = marta.size()-1; i > marta.size() -6 ; i-- ) {
              if(margen.get(l).findNameMarg((double)marta.get(i)) != null){
              	System.out.println("Nombre: "+margen.get(l).findNameMarg((double)marta.get(i))+"|| Mail: "+margen.get(l).findMailMarg((double)marta.get(i)));
              }
            }
          }
          
          
          

          mi_csv.close();
    }
}