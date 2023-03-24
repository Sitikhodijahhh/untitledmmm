import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ConnectFirst {
        public static void main(String[] args) throws IOException {
            ConnectURI koneksisaya = new ConnectURI();
            URL myAddress = koneksisaya.buildURL
                    ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
            String response = koneksisaya.getresponseFromHttpUrl(myAddress);
            System.out.println(response);

            assert response != null;
            JSONArray responseJSON = new JSONArray(response);
            ArrayList<ResponModel> responseModel =
                    new ArrayList<>();
            for(int i=0;i< responseJSON.length();i++){
                ResponModel resModel = new ResponModel();
                JSONObject myJSONObject =
                        responseJSON.getJSONObject(i);
                resModel.setI_code(myJSONObject.
                        getString("i_code"));
                resModel.setG_code(myJSONObject.
                        getString( "g_code"));
                resModel.setI_supp(myJSONObject.
                        getString( "i_supp"));
                resModel.setI_barcode(myJSONObject.
                        getString( "i_barcode"));
                resModel.setI_name(myJSONObject.
                        getString( "i_name"));
                resModel.setI_qty(myJSONObject.
                        getString( "i_qty"));
                resModel.setI_qtymin(myJSONObject.
                        getString( "i_qtymin"));
                resModel.setI_unit(myJSONObject.
                        getString( "i_unit"));
                resModel.setI_size(myJSONObject.
                        getString( "i_size"));
                resModel.setI_color(myJSONObject.
                        getString( "i_color"));
                resModel.setI_brands(myJSONObject.
                        getString( "i_brands"));
                resModel.setI_article(myJSONObject.
                        getString( "i_article"));
                resModel.setI_cogs(myJSONObject.
                        getString( "i_cogs"));
                resModel.setI_kdsell(myJSONObject.
                        getString( "i_kdsell"));
                resModel.setI_sell(myJSONObject.
                        getString( "i_sell"));
                resModel.setI_status(myJSONObject.
                        getString( "i_status"));
                responseModel.add(resModel);

            }

            System.out.println("Response are: ");
            for(int index=0; index<responseModel.size();index++){
               int harga= Integer.parseInt(responseModel.get(index).getI_sell());
               if (responseModel.get(index).getI_name().contains("S")&& harga < 7000){
                   System.out.println("Nama : " + responseModel.get(index).getI_name());
                   System.out.println("Harga : " + responseModel.get(index).getI_sell());
               }
            }
        }
    }


