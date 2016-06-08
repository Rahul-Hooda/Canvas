package com.example.rahulhooda.demoapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahul.hooda on 6/1/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<Person> persons;
    Activity context;

    public void initializeData(List<Person> persons, Activity context){
        this.persons = persons;
        this.context = context;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = context.getLayoutInflater().inflate(R.layout.row_view, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).name);
        holder.personAge.setText(persons.get(position).age);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView personName;
        TextView personAge;

        PersonViewHolder(View itemView) {
            super(itemView);
            personName = (TextView) itemView.findViewById(R.id.textviewPersonName);
            personAge = (TextView) itemView.findViewById(R.id.textviewPersonAge);
        }
    }

}
