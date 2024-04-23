package com.example.animalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Animal> animals;
    AnimalAdapter animalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        animals = new ArrayList<>();

        animals.add(new Animal("bear", R.drawable.bear));
        animals.add(new Animal("beef", R.drawable.beef));
        animals.add(new Animal("deer", R.drawable.deer));
        animals.add(new Animal("dog", R.drawable.dog));
        animals.add(new Animal("fox", R.drawable.fox));
        animals.add(new Animal("tiger", R.drawable.tiger));
        animals.add(new Animal("Turtle", R.drawable.turtle));
        animals.add(new Animal("giraffe", R.drawable.giraffe));

        animals.add(new Animal("Monkey", R.drawable.monkey));
        animals.add(new Animal("Rhino", R.drawable.rihnosoure));
        animals.add(new Animal("tiger", R.drawable.tiger));
        animals.add(new Animal("turtle", R.drawable.turtle));
        animals.add(new Animal("turtle", R.drawable.turtle));
        animals.add(new Animal("fox", R.drawable.fox));
        animals.add(new Animal("fox", R.drawable.fox));
        animals.add(new Animal("fox", R.drawable.fox));
        animals.add(new Animal("fox", R.drawable.fox));

        animalAdapter = new AnimalAdapter(animals, this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(animalAdapter);

        // Add three new items to the list
      //  ArrayList<Animal> newAnimals = new ArrayList<>();
        // newAnimals.add(new Animal("Lion", R.drawable.zebra));
        // newAnimals.add(new Animal("Zebra", R.drawable.zebra));
        // newAnimals.add(new Animal("Elephant", R.drawable.zebra));
        //  animalAdapter.addItems(0, newAnimals);

        // animalAdapter.removeItems(5, 3);  // Remove items from position 0 to 4 (5 items)

        //3
        //  Animal newAnimal = new Animal("New Animal", R.drawable.koalamarsupial);
        //  animalAdapter.insertItemAtPosition(newAnimal, 6); // 6 because positions are zero-based

        //4

      //  animalAdapter.removeItemAtPosition(6);

        //5
       // animalAdapter.notifyRangeChanged(0, 6);
    }



    //  updateData();


    //  1.// void updateData() {
    // Create a new dataset or fetch new data
    //  ArrayList<Animal> newData = new ArrayList<>();
    //  newData.add(new Animal("Elephant", R.drawable.zebra));
    //  newData.add(new Animal("Lion", R.drawable.zebra));

    // Update the dataset in the adapter

    // animalAdapter.updateData(newData);// const list of animal = new data -- 2








    @Override
    public void onItemClick(int positionOfTheAnimal) {
        Toast.makeText(this, "Clicked "+animals.get(positionOfTheAnimal).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(positionOfTheAnimal).getImage());
        intent.putExtra("name",animals.get(positionOfTheAnimal).getName());
        startActivity(intent);

    }


}