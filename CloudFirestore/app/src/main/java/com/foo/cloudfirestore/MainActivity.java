package com.foo.cloudfirestore;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DocSnippets";

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeCloudFirestore();

        addData();
//        getADocument();


//        addDataFromCustomObject();
//        getDocumentAsCustomObject();

//        getMultipleDocumentsFromACollection();
        //getAllDocumentsInACollection();

        //createSubCollectionWithTheSameID();
        //collectionGroupQuery();

        //getDocumentsWidthOrderAndLimitData();

    }

    private void initializeCloudFirestore() {
        // Access a Cloud Firestore instance from your Activity
        db = FirebaseFirestore.getInstance();
    }

    private void addData() {
        CollectionReference cities = db.collection("cities");

        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
        data1.put("timestamp", FieldValue.serverTimestamp());
        cities.document("SF").set(data1);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("name", "Los Angeles");
        data2.put("state", "CA");
        data2.put("country", "USA");
        data2.put("capital", false);
        data2.put("population", 3900000);
        data2.put("regions", Arrays.asList("west_coast", "socal"));
        data2.put("timestamp", FieldValue.serverTimestamp());
        cities.document("LA").set(data2);

        Map<String, Object> data3 = new HashMap<>();
        data3.put("name", "Washington D.C.");
        data3.put("state", null);
        data3.put("country", "USA");
        data3.put("capital", true);
        data3.put("population", 680000);
        data3.put("regions", Arrays.asList("east_coast"));
        data3.put("timestamp", FieldValue.serverTimestamp());
        cities.document("DC").set(data3);

        Map<String, Object> data4 = new HashMap<>();
        data4.put("name", "Tokyo");
        data4.put("state", null);
        data4.put("country", "Japan");
        data4.put("capital", true);
        data4.put("population", 9000000);
        data4.put("regions", Arrays.asList("kanto", "honshu"));
        data4.put("timestamp", FieldValue.serverTimestamp());
        cities.document("TOK").set(data4);

        Map<String, Object> data5 = new HashMap<>();
        data5.put("name", "Beijing");
        data5.put("state", null);
        data5.put("country", "China");
        data5.put("capital", true);
        data5.put("population", 21500000);
        data5.put("regions", Arrays.asList("jingjinji", "hebei"));
        data5.put("timestamp", FieldValue.serverTimestamp());
        cities.document("BJ").set(data5);

        Map<String, Object> data6 = new HashMap<>();
        data6.put("name", "Seoul");
        data6.put("state", null);
        data6.put("country", "Korea");
        data6.put("capital", true);
        data6.put("population", 21500000);
        data6.put("regions", Arrays.asList("west_coast", "Seoul"));
        data6.put("timestamp", FieldValue.serverTimestamp());
        cities.document("SE").set(data6);

        Map<String, Object> data7 = new HashMap<>();
        data7.put("name", "Pusan");
        data7.put("state", null);
        data7.put("country", "Korea");
        data7.put("capital", true);
        data7.put("population", 21500000);
        data7.put("regions", Arrays.asList("south", "Pusan"));
        data7.put("timestamp", FieldValue.serverTimestamp());
        cities.document("PU").set(data7);

        Map<String, Object> data8 = new HashMap<>();
        data8.put("name", "Incheon");
        data8.put("state", null);
        data8.put("country", "Korea");
        data8.put("capital", true);
        data8.put("population", 21500000);
        data8.put("regions", Arrays.asList("west", "Incheon"));
        data8.put("timestamp", FieldValue.serverTimestamp());
        cities.document("IN").set(data8);
    }

    private void getADocument() {
        DocumentReference docRef = db.collection("cities").document("SF");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> data = document.getData();

                        Log.d(TAG, "DocumentSnapshot data: " + data);

                        String country = (String) data.get("country");
                        boolean isCapital = (boolean) data.get("capital");
                        List<String> regions = (List<String>) data.get("regions");
                        for (String region: regions) {
                            Log.d(TAG, "region = " + region);
                        }
                        String name = (String) data.get("name");
                        String state = (String) data.get("state");
                        long population = (long) data.get("population");
                        Timestamp timestamp = (Timestamp) data.get("timestamp");
                        Log.d(TAG, "timestamp = " + timestamp);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    private void getDocumentsWidthOrderAndLimitData() {
        db.collection("cities").orderBy("name").limit(3).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                QuerySnapshot result = task.getResult();
                List<DocumentSnapshot> documents = result.getDocuments();
                for (DocumentSnapshot doc: documents) {
                    Log.d(TAG, doc.getId() + ": " + doc.getData());
                }
            }
        });
    }

    private void getMultipleDocumentsFromACollection() {
        db.collection("cities")
                .whereEqualTo("capital", true)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    private void getAllDocumentsInACollection() {
        db.collection("cities")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    private void addDataFromCustomObject() {
        City city = new City("Los Angeles", "CA", "USA",
                false, 5000000L, Arrays.asList("west_coast", "sorcal"));
        db.collection("cities").document("LA").set(city);
    }

    private void getDocumentAsCustomObject() {
        DocumentReference docRef = db.collection("cities").document("LA");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                City city = documentSnapshot.toObject(City.class);

                long population = city.getPopulation();
                Log.d(TAG, "population = " + population);
                Timestamp timestamp = city.getTimestamp();
                Log.d(TAG, "timestamp = " + timestamp.toDate().toString());
            }
        });
    }

    private void createSubCollectionWithTheSameID() {
        CollectionReference citiesRef = db.collection("cities");

        Map<String, Object> ggbData = new HashMap<>();
        ggbData.put("name", "Golden Gate Bridge");
        ggbData.put("type", "bridge");
        citiesRef.document("SF").collection("landmarks").add(ggbData);

        Map<String, Object> lohData = new HashMap<>();
        lohData.put("name", "Legion of Honor");
        lohData.put("type", "museum");
        citiesRef.document("SF").collection("landmarks").add(lohData);

        Map<String, Object> gpData = new HashMap<>();
        gpData.put("name", "Griffith Park");
        gpData.put("type", "park");
        citiesRef.document("LA").collection("landmarks").add(gpData);

        Map<String, Object> tgData = new HashMap<>();
        tgData.put("name", "The Getty");
        tgData.put("type", "museum");
        citiesRef.document("LA").collection("landmarks").add(tgData);

        Map<String, Object> lmData = new HashMap<>();
        lmData.put("name", "Lincoln Memorial");
        lmData.put("type", "memorial");
        citiesRef.document("DC").collection("landmarks").add(lmData);

        Map<String, Object> nasaData = new HashMap<>();
        nasaData.put("name", "National Air and Space Museum");
        nasaData.put("type", "museum");
        citiesRef.document("DC").collection("landmarks").add(nasaData);

        Map<String, Object> upData = new HashMap<>();
        upData.put("name", "Ueno Park");
        upData.put("type", "park");
        citiesRef.document("TOK").collection("landmarks").add(upData);

        Map<String, Object> nmData = new HashMap<>();
        nmData.put("name", "National Museum of Nature and Science");
        nmData.put("type", "museum");
        citiesRef.document("TOK").collection("landmarks").add(nmData);

        Map<String, Object> jpData = new HashMap<>();
        jpData.put("name", "Jingshan Park");
        jpData.put("type", "park");
        citiesRef.document("BJ").collection("landmarks").add(jpData);

        Map<String, Object> baoData = new HashMap<>();
        baoData.put("name", "Beijing Ancient Observatory");
        baoData.put("type", "museum");
        citiesRef.document("BJ").collection("landmarks").add(baoData);
    }

    private void collectionGroupQuery() {
        db.collectionGroup("landmarks").whereEqualTo("type", "museum").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot doc: documents) {
                            Log.d(TAG, doc.getId() + ": " + doc.getData());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "error on collection group query: " + e.getMessage());
                    }
                });

    }


}