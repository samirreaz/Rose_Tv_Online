package com.rosetvonline.rosetvonline.RoseC;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.rosetvonline.rosetvonline.Home.Post_item;
import com.rosetvonline.rosetvonline.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class Go_Y_Fragment extends Fragment {
    private Context context;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference eventRef;

    private Uri gallary_imageURL;
    private StorageTask uploadStorageTask;
    private StorageReference storageReference;

    private String s_category, s_mawlana, s_year;
    private static final int GALLERY_CODE = 1;
    private static final int RESULT_OK = -1;

    private ImageButton imageButton;
    private TextInputEditText titleET, descriptionET, tagsET, videoURL;
    private AppCompatSpinner categorySP, mawlanaSP, yearSP;
    private Button signOut, postSubmit;
    private ContentLoadingProgressBar progressBar;

    public Go_Y_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_go__y_, container, false);
        initilizeComponent(view);


        if (user != null) {
           /* userRef = rootRef.child(user.getUid());
            eventRef = userRef.child("Posts");*/
            eventRef = rootRef.child("Posts");
        }

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user != null) {
                    firebaseAuth.signOut();

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.admin_container, new LoginFragment());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                /*String postID = eventRef.push().getKey();
                String imageURL = "";
                String postTitle = titleET.getText().toString();
                String postDescription = descriptionET.getText().toString();
                String postCategory = s_category;
                String mawlanaName = s_mawlana;
                String postYear = s_year;
                String postTags = tagsET.getText().toString();
                String youtubeURL = videoURL.getText().toString();

                String postId = eventRef.push().getKey();

                Post_item post_item = new Post_item(postID, imageURL, postTitle, postDescription, postCategory, mawlanaName, postYear, postTags, youtubeURL);
                eventRef.child(postId).setValue(post_item);*/
            }
        });


        postSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (uploadStorageTask != null && uploadStorageTask.isInProgress()) {
                    Toast.makeText(context, "Upload is Progress", Toast.LENGTH_SHORT).show();
                } else {
                    if (user != null && gallary_imageURL != null
                            && !titleET.getText().toString().isEmpty()
                            && !descriptionET.getText().toString().isEmpty()
                            && !s_category.isEmpty()
                            && !s_mawlana.isEmpty()
                            && !s_year.isEmpty()
                            && !tagsET.getText().toString().isEmpty()
                            && !videoURL.getText().toString().isEmpty()) {
                        StorageReference storageFilePath = storageReference.child(System.currentTimeMillis() + "." + getFileExtention(gallary_imageURL));
                        uploadStorageTask = storageFilePath.putFile(gallary_imageURL).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                               /* Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(0);
                                    }
                                },500);*/

                                Task<Uri> imageDownloadUri = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                                imageDownloadUri.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        String postID = eventRef.push().getKey();
                                        String imageURL = uri.toString();
                                        //Toast.makeText(getContext(), "imageURL", Toast.LENGTH_SHORT).show();
                                        String postTitle = titleET.getText().toString();
                                        String postDescription = descriptionET.getText().toString();
                                        String postCategory = s_category;
                                        String mawlanaName = s_mawlana;
                                        String postYear = s_year;
                                        String postTags = tagsET.getText().toString();
                                        String youtubeURL = videoURL.getText().toString();

                                        String postId = eventRef.push().getKey();

                                        Post_item post_item = new Post_item(postID, imageURL, postTitle, postDescription, postCategory, mawlanaName, postYear, postTags, youtubeURL);
                                        eventRef.child(postId).setValue(post_item);

                                        titleET.setText ("");
                                        descriptionET.setText ("");
                                        tagsET.setText ("");
                                        videoURL.setText ("");
                                        s_category="";
                                        s_mawlana="";
                                        s_year="";
                                    }
                                });
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                        double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                        progressBar.setProgress((int) progress);
                                    }
                                });
                    }else {
                        Toast.makeText(getContext(), "Please!! fill all information.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

//User is exist or not---------------------->
        if (user != null) {
            //this condition for check user is valid or Not..
            //titleET.setText(user.getEmail().toString());
        } else titleET.setText("null");


        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(getContext(), R.array.category, android.R.layout.simple_spinner_dropdown_item);
        categorySP.setAdapter(categoryAdapter);
        categorySP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(),parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                if (parent.getItemIdAtPosition(position) != 0) {
                    s_category = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getContext(), s_category, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> mawlanaAdapter = ArrayAdapter.createFromResource(getContext(), R.array.mawlana_name, android.R.layout.simple_spinner_dropdown_item);
        mawlanaSP.setAdapter(mawlanaAdapter);
        mawlanaSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(),parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                if (parent.getItemIdAtPosition(position) != 0) {
                    s_mawlana = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getContext(), s_mawlana, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(getContext(), R.array.year, android.R.layout.simple_spinner_dropdown_item);
        yearSP.setAdapter(yearAdapter);
        yearSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(),parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                if (parent.getItemIdAtPosition(position) != 0) {
                    s_year = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getContext(), s_year, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_CODE);
            }
        });


        return view;
    }

    private String getFileExtention(Uri uri) {
        ContentResolver cR = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            gallary_imageURL = data.getData();
            //Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
            //imageButton.setImageURI(gallary_imageURL);

            Picasso.get ()
                    //.with(getContext())
                    .load(gallary_imageURL)
                    .fit()
                    //.centerCrop()
                    .placeholder(R.drawable.common_google_signin_btn_icon_dark_normal_background)
                    .into(imageButton);
        }
    }

    private void initilizeComponent(View view) {

        imageButton = view.findViewById(R.id.imageButton);
        titleET = view.findViewById(R.id.et_title);
        descriptionET = view.findViewById(R.id.et_description);
        categorySP = view.findViewById(R.id.sp_category);
        mawlanaSP = view.findViewById(R.id.sp_mawlana);
        yearSP = view.findViewById(R.id.sp_year);
        tagsET = view.findViewById(R.id.et_tag);
        videoURL = view.findViewById(R.id.et_URL);
        progressBar = view.findViewById(R.id.progressBar_post);

        signOut = view.findViewById(R.id.btn_signOut);
        postSubmit = view.findViewById(R.id.btn_postSubmit);

        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        rootRef = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference("PostImage");


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach (context);
        this.context = context;
    }
}
