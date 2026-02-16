package com.example.customrecyclerlist;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLFood {

    private Food[] data;
    private Context context;


    public XMLFood(Context context) {
        this.context = context;

        Log.e("ERROR", "IN PARSING NOW");

        InputStream stream = null;
        DocumentBuilder builder = null;
        Document document = null;

        try {
            stream = context.getResources().openRawResource(R.raw.foods);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
            Log.e("ERROR", "STREAM BUILDER AND DOCUMENT GENERATED");
        } catch (Exception e) {

        }

        NodeList nameList = document.getElementsByTagName("name");
        NodeList descriptionList = document.getElementsByTagName("description");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList urlList = document.getElementsByTagName("url");
        NodeList ingredientsList = document.getElementsByTagName("ingredients");
        NodeList instructionsList = document.getElementsByTagName("instruction");
        NodeList subtitlesList = document.getElementsByTagName("subtitle");


        data = new Food[nameList.getLength()];

        for (int i = 0; i < nameList.getLength(); i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String ingredients = ingredientsList.item(i).getFirstChild().getNodeValue();
            String subtitle = subtitlesList.item(i).getFirstChild().getNodeValue();
            String instruction = instructionsList.item(i).getFirstChild().getNodeValue();


            data[i] = new Food(name, image, subtitle, description, url, ingredients, instruction);


        }
    }

    public int getCount(){return data.length;}
    public Food getFood(int i){return data[i];}
    public String [] getNames(){
        String [] names = new String[getCount()];
        for(int i=0;i<getCount();i++)names[i] = getFood(i).getName();
        return names;
    }

    public String [] getSubtitles(){
        String [] subtitles = new String[getCount()];
        for(int i=0;i<getCount();i++)subtitles[i] = getFood(i).getSubtitle();
        return subtitles;
    }
    public int [] getImageIds(){
        int [] imageIds = new int[getCount()];
        for(int i=0;i<getCount();i++){
            String imageName = getFood(i).getImage();
            imageName = imageName.substring(0, imageName.indexOf("."));
            imageIds[i] = this.context.getResources().getIdentifier(imageName,"drawable", context.getPackageName());
        }

        return imageIds;
    }
}
