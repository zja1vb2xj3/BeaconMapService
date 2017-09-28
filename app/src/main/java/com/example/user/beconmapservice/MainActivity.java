package com.example.user.beconmapservice;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button partButtons[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        partButtons = new Button[8];

        partButtons[0] = (Button) findViewById(R.id.part1);
        partButtons[1] = (Button) findViewById(R.id.part2);
        partButtons[2] = (Button) findViewById(R.id.part3);
        partButtons[3] = (Button) findViewById(R.id.part4);
        partButtons[4] = (Button) findViewById(R.id.part5);
        partButtons[5] = (Button) findViewById(R.id.part6);
        partButtons[6] = (Button) findViewById(R.id.part7);
        partButtons[7] = (Button) findViewById(R.id.part8);

        for(int i=0; i<8; i++){
            partButtons[i].setOnClickListener(onClickListener);
        }

    }

    private ButtonModel[] buttonModels;

    @Override
    protected void onResume() {
        super.onResume();

        buttonModels = new ButtonModel[8];

        buttonModels[0] = new ButtonModel("카메라 코너", "가격 : 500.000");
        buttonModels[1] = new ButtonModel("가스레인지 코너", "가격 : 200.000");
        buttonModels[2] = new ButtonModel("가습기 코너", "가격 : 300.000");
        buttonModels[3] = new ButtonModel("다리미 코너", "가격 : 50000");
        buttonModels[4] = new ButtonModel("전자레인지 코너", "가격 : 100.000");
        buttonModels[5] = new ButtonModel("모니터 코너", "가격 : 150.000");
        buttonModels[6] = new ButtonModel("청소기 코너", "가격 : 100.000");
        buttonModels[7] = new ButtonModel("세탁기 코너", "가격 : 1.000.000"); 
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.part1:
                    createListDialog(IconConstant.CAMERA_ICON, buttonModels[0]);
                    break;

                case R.id.part2:
                    createListDialog(IconConstant.GASRANGE_ICON, buttonModels[1]);
                    break;

                case R.id.part3:
                    createListDialog(IconConstant.HUMIDIFIER_ICON, buttonModels[2]);
                    break;

                case R.id.part4:
                    createListDialog(IconConstant.IRON_ICON, buttonModels[3]);
                    break;

                case R.id.part5:
                    createListDialog(IconConstant.MICROWAVERANGE_ICON, buttonModels[4]);
                    break;

                case R.id.part6:
                    createListDialog(IconConstant.MONITOR_ICON, buttonModels[5]);
                    break;

                case R.id.part7:
                    createListDialog(IconConstant.SCAVENGER_ICON, buttonModels[6]);
                    break;

                case R.id.part8:
                    createListDialog(IconConstant.WASHINGMACHINE_ICON, buttonModels[7]);
                    break;


            }//end switch
        }//end onClick
    };//end onClickListener

    private void createListDialog(int iconId, ButtonModel buttonModel){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(iconId);
        builder.setTitle("선택한 위치 정보");

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "확인 버튼을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_item);

        arrayAdapter.add(buttonModel.getTitle());
        arrayAdapter.add(buttonModel.getContent());

        builder.setAdapter(arrayAdapter, null);
        builder.show();
    }

}
