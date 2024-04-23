package com.example.animalsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context, MyClickInterface myClickInterface){
        this.context = context;
        this.animalData = animalData;
        this.myClickInterface = myClickInterface;

    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false);

        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.txtAnimalName.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animalData.size();
    }


    //1
  //  public void addItems(int position, ArrayList<Animal> newAnimals) {
    //    animalData.addAll(position, newAnimals);
    //    notifyItemRangeInserted(position, newAnimals.size());
  //  }

    //2
  /*  public void removeItems(int positionStart, int itemCount) {
        int positionEnd = positionStart + itemCount;
        animalData.subList(positionStart, positionEnd).clear();
        notifyItemRangeRemoved(positionStart, itemCount);
    }*/

    //3
   // public void insertItemAtPosition(Animal animal, int position) {
    //    animalData.add(position, animal);
     //   notifyItemInserted(position);
 //   }

     //4
   /*  public void removeItemAtPosition(int position) {
         animalData.remove(position);
         notifyItemRemoved(position);
     }*/

   //5
   // Method to notify adapter of range changes
  /* public void notifyRangeChanged(int startPosition, int itemCount) {
       // Modify data directly at each position in the range
       for (int i = startPosition; i < startPosition + itemCount; i++) {
           animalData.get(i).setName("Modified Name " + i);
       }
       // Notify adapter of changes in the range
       notifyItemRangeChanged(startPosition, itemCount);*/
  // }



    class AnimalRowHolder extends RecyclerView.ViewHolder{

        TextView txtAnimalName;
        ImageView imgAnimal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            txtAnimalName = itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = itemView.findViewById(R.id.img_animal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }

            });
        }
    }

    interface MyClickInterface{
        void onItemClick(int positionOfTheAnimal);
    }


   // public void updateData(ArrayList<Animal> newData) {
       // animalData.clear(); // Clear the existing dataset
       // animalData.addAll(newData); // Add the new data to the dataset
       // notifyDataSetChanged(); // Notify the adapter of dataset change
  //  }

}

