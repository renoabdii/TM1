import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI mykoneksi = new ConnectURI();
        URL myAddress = ConnectURI.buildURL
                ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = ConnectURI.getresponsefromhttpUrl(myAddress);
        System.out.println(response);

        //decoding JSON
        assert response != null;
        JSONArray responseJSON = new JSONArray (response);
        ArrayList <FarmasiData> models = new ArrayList<>();


        for (int i=0;i< responseJSON.length();i++) {
            FarmasiData farData = new FarmasiData();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            farData.setI_code(myJSONObject.getString("i_code"));
            farData.setG_code(myJSONObject.getString("g_code"));
            farData.setI_supp(myJSONObject.getString("i_supp"));
            farData.setI_barcode(myJSONObject.getString("i_barcode"));
            farData.setI_name(myJSONObject.getString("i_name"));
            farData.setI_qty(myJSONObject.getString("i_qty"));
            farData.setI_qtymin(myJSONObject.getString("i_qtymin"));
            farData.setI_unit(myJSONObject.getString("i_unit"));
            farData.setI_color(myJSONObject.getString("i_color"));
            farData.setI_size(myJSONObject.getString("i_size"));
            farData.setI_brands(myJSONObject.getString("i_brands"));
            farData.setI_article(myJSONObject.getString("i_article"));
            farData.setI_cogs(myJSONObject.getString("i_cogs"));
            farData.setI_kdsell(myJSONObject.getString("i_kdsell"));
            farData.setI_sell(myJSONObject.getString("i_sell"));
            farData.setI_status(myJSONObject.getString("i_status"));
            farData.setId(myJSONObject.getString("id"));
            models.add(farData);
        }
        System.out.println("Response are : ");
        for (int index = 0; index<models.size();index++){
/// mengkonversi string menjadi int
            int harga = Integer.parseInt(models.get(index).getI_sell());

            if(models.get(index).getI_name().contains("S")&& harga < 7000){
                System.out.println("NAME : " + models.get(index).getI_name());
                System.out.println("HARGA : " + models.get(index).getI_sell());}
        }
                }
            }




