package com.example.android.restful;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.restful.model.DataItem;

import static com.example.android.restful.data.MyAdapterRealmAdapter.SINGLE_DATA_ITEM;

/**
 * Created by hp on 1/11/2018.
 */

public class DetailsViewActivity extends AppCompatActivity {
    private DataItem dataItem;
    private TextView textViewHeadline, textViewDescription, textViewInfo, textViewPrice;
    private ImageView imageViewDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) dataItem = bundle.getParcelable(SINGLE_DATA_ITEM);
        if (dataItem != null) {
            Toast.makeText(getApplicationContext(), "Data found", Toast.LENGTH_SHORT).show();
        }
        initializeView();
        setupView(dataItem);
    }


    private void initializeView() {
        textViewHeadline = (TextView) findViewById(R.id.textViewHeadline);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
    }

    private void setupView(DataItem dataItem) {
        textViewHeadline.setText(dataItem.getItemName());
        textViewInfo.setText(dataItem.getCategory());
        textViewPrice.setText(String.format("price:%s", dataItem.getPrice()));
        textViewDescription.setText(dataItem.getDescription());
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_task_editor, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        super.onPrepareOptionsMenu(menu);
//
//        if (mCurrentTaskUri == null) {
//            MenuItem deleteMenu = menu.findItem(R.id.action_delete);
//            deleteMenu.setVisible(false);
//        }
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // User clicked on a menu option in the app bar overflow menu
//        switch (item.getItemId()) {
//            // Respond to a click on the "Save" menu option
//            case R.id.action_save:
//                saveTask();
//                finish();
//                return true;
//            // Respond to a click on the "Delete" menu option
//            case R.id.action_delete:
//                showDeleteConfirmationDialog();
//                return true;
//            // Respond to a click on the "Up" arrow button in the app bar
//            case android.R.id.home:
//                // Navigate back to parent activity (CatalogActivity)
//                if (!mTaskHasChanged) {
//                    NavUtils.navigateUpFromSameTask(this);
//                    return true;
//                } else {
//                    showUnsavedChangeDialog(HOME_BUTTON);
//                    return true;
//                }
//
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void saveTask() {
//        String nameString = mNameEditText.getText().toString().trim();
//        String descriptionString = mDescriptionEditText.getText().toString();
//        int unixTime = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//        if (TextUtils.isEmpty(nameString)) {
//            return;
//        }
//
//        // Creating contentValues which will be used for database data insert
//        ContentValues values = new ContentValues();
//        values.put(TaskEntry.COLUMN_TASK_NAME, nameString);
//        values.put(TaskEntry.COLUMN_TASK_DESCRIPTION, descriptionString);
//
//        if (mCurrentTaskUri == null) {
//            values.put(TaskEntry.COLUMN_TASK_DATE_CREATED, unixTime);
//            Uri newUri = getContentResolver().insert(TaskEntry.CONTENT_URI, values);
//            if (newUri == null) {
//                Toast.makeText(getApplicationContext(), getString(R.string.editor_insert_task_failed),
//                        Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(getApplicationContext(), getString(R.string.editor_insert_task_successful),
//                        Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        } else {
//            values.put(TaskEntry.COLUMN_TASK_DATE_UPDATED, unixTime);
//
//            int rowAffected = getContentResolver().update(mCurrentTaskUri, values, null, null);
//            if (rowAffected == 0) {
//                Toast.makeText(getApplicationContext(), getString(R.string.editor_task_update_failed),
//                        Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(getApplicationContext(), getString(R.string.editor_task_update_successful),
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//
//    private void showUnsavedChangeDialog(final int buttonID) {
//        DialogInterface.OnClickListener discardButtonClickListener =
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if (buttonID == BACK_PRESSED_BUTTON) {
//                            finish();
//                        } else if (buttonID == HOME_BUTTON) {
//                            NavUtils.navigateUpFromSameTask(TaskEditorActivity.this);
//                        }
//                    }
//                };
//        DialogInterface.OnClickListener keepEditingListener =
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        // User clicked the "keep editing" button, so dismiss the dialog and
//                        // continue editing the pet.
//                        if (dialogInterface != null) {
//                            dialogInterface.dismiss();
//                        }
//                    }
//                };
//        // Create an AlertDialog.Builder and the message, and click listeners
//        // for the positive and negative buttons on the dialog.
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.unsaved_changes_dialog_msg);
//        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
//        builder.setNegativeButton(R.string.keep_editing, keepEditingListener);
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
//
//
//    private void showDeleteConfirmationDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.delete_dialog_msg);
//        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                deleteTask();
//            }
//        });
//        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (dialogInterface != null) {
//                    dialogInterface.dismiss();
//                }
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
//
//    private void deleteTask() {
//        int rowDeleted = getContentResolver().delete(mCurrentTaskUri, null, null);
//        if (rowDeleted == 0) {
//            Toast.makeText(getApplicationContext(), R.string.editor_delete_task_failed,
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), R.string.editor_delete_task_successful,
//                    Toast.LENGTH_SHORT).show();
//        }
//        finish();
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (!mTaskHasChanged) {
//            super.onBackPressed();
//            return;
//        }
//        showUnsavedChangeDialog(BACK_PRESSED_BUTTON);
//    }
}
