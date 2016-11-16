package com.example.eliseeva.lab1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


class NoteAdapter extends ArrayAdapter<Note> {

    List<Note> notes;
    //ItemFilter mFilter = new ItemFilter();
    Context c;
    LayoutInflater notesInflater;

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, R.layout.note_list_element, notes);
        c = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(notesInflater == null) {
            notesInflater = LayoutInflater.from(getContext());
        }
        View myView = notesInflater.inflate(R.layout.note_list_element, parent, false);

        Note item = getItem(position);
        TextView title = (TextView) myView.findViewById(R.id.titleTextView);
        TextView datetime = (TextView) myView.findViewById(R.id.dateTextView);

        ImageView image = (ImageView) myView.findViewById(R.id.noteImage);
        ImageView imp = (ImageView) myView.findViewById(R.id.impImage);

        title.setText(item.Title);

        datetime.setText(item.DateTime);

        switch (item.Importance){
            case 0:
                imp.setImageResource(R.drawable.i3);
                break;
            case 1:
                imp.setImageResource(R.drawable.i2);
                break;
            case 2:
                imp.setImageResource(R.drawable.i1);
        }

        if(item.Image.equals("")){
            image.setImageBitmap(BitmapLoader.decodeBitmapFromResource(getContext().getResources(), R.drawable.image, 60,60));
        }
        else{
            image.setImageBitmap(BitmapLoader.decodeBitmapFromPath(item.Image,60,60));
        }
        return myView;

    }

    public int getId(){
        int maxId = 0;
        for(Note note: notes){
            if(note.Id > maxId)
                maxId = note.Id;
        }
        return maxId+1;
    }

    public Note getItemById(int id){
        for(Note note: notes)
            if (note.Id == id) {
                return note;
            }
        return null;
    }

    @Override
    public void add(Note object) {
        notes.add(object);
    }

    @Nullable
    @Override
    public Note getItem(int position) {
        return notes.get(position);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    public void removeById(int id) {
    }

    public void changeById(int id, Note note_new) {
    }
}