package com.example.trialxmljson;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    Button btnXML, btnJSON;
    TextView txtJSON, txtXML;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnXML = findViewById(R.id.button);
        btnJSON = findViewById(R.id.button2);
        txtXML = findViewById(R.id.textView);
        txtJSON = findViewById(R.id.textView2);
        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("city.xml");
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(inputStream);
                    StringBuilder xmlData = new StringBuilder();
                    xmlData.append("Data from XML");
                    xmlData.append("\n--------------");
                    NodeList nodeList = document.getElementsByTagName("place");
                    for (int i=0; i<nodeList.getLength(); i++ ){
                        Node node = nodeList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE){
                            Element element = (Element)node;
                            xmlData.append("\nCity Name: ").append(getValue("name", element));
                            xmlData.append("\nLatitude: ").append(getValue("lat", element));
                            xmlData.append("\nLongitude: ").append(getValue("long", element));
                            xmlData.append("\nTemperature: ").append(getValue("temp", element));
                            xmlData.append("\nHumidity: ").append(getValue("humidity", element));
                            xmlData.append("\n-------------");
                        }
                    }

                    txtXML.setText(xmlData.toString());
                }catch (Exception ex){
                    ex.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error Parsing XML Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                try {

                    InputStream is = getAssets().open("city.json");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    String jsonString = new String(buffer, StandardCharsets.UTF_8);
                    JSONArray jsonArray = new JSONArray(jsonString);
                    StringBuilder jsonData = new StringBuilder();
                    jsonData.append("Data from JSON");
                    jsonData.append("\n-----------");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        jsonData.append("\nCity Name: ").append(jsonObject.getString("name"));
                        jsonData.append("\nLatitude: ").append(jsonObject.getString("lat"));
                        jsonData.append("\nLongitude: ").append(jsonObject.getString("long"));
                        jsonData.append("\nTemperature: ").append(jsonObject.getString("temp"));
                        jsonData.append("\nHumidity: ").append(jsonObject.getString("humidity"));
                        jsonData.append("\n-------------");
                    }
                    txtJSON.setText(jsonData.toString());
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error Parsing JSON Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String getValue(String tag, Element element){
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}