package com.adithyapai.jsonxmlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    TextView tt;

    // By Adithya Pai B : )


    /*

    Make the two files in asset folder
    city.json

    {
  "city": "Mangalore",
  "lat": "12.971599",
   "long": "77.594597",
  "temperature": 36
}


data.xml
<city>
    <name>Bangalore</name>
    <lat>69.99</lat>
    <lng>96.66</lng>
    <temp>25</temp>
</city>


*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = findViewById(R.id.textView);
        findViewById(R.id.jsonBtn).setOnClickListener(view -> {
            try {
                InputStream is = getAssets().open("city.json");
                byte b [] = new byte[is.available()];
                is.read(b);
                is.close();
                JSONObject jsonObject = new JSONObject(new String(b, "UTF-8"));
                tt.setText( "JSON DATA \n\nCity:    " + jsonObject.getString("city")  + "\n\nLatitude :  " + jsonObject.getInt("lat") + "\n\nLongitude:    " + jsonObject.getInt("long") + "\n\nTemperature: " + jsonObject.getInt("temperature"));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }


        });
        findViewById(R.id.xmlBtn).setOnClickListener(view -> {
            try {
                InputStream is = getAssets().open("data.xml");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(is);
                doc.getDocumentElement().normalize();
                    Element element = (Element) doc.getElementsByTagName("city").item(0);
                    tt.setText("XML DATA \n\nCity:  " + call("name", element) + "\n\n" + "Latitude" + call("lat", element) + "\n\n" + "Longitude" + call("lng", element) + "\n\n" + "Temperature" + call("temp", element));

            } catch (IOException | SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }

        });

    }
    public  String  call(String m, Element e){
        return e.getElementsByTagName(m).item(0).getTextContent();

    }
}