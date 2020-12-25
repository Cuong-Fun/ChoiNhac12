package com.manhcuong.choinhac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.manhcuong.choinhac.adapter.BaiDangAdapter;
import com.manhcuong.choinhac.object.BaiDang;
import com.manhcuong.choinhac.object.FakeData;
import com.manhcuong.choinhac.object.NguoiDang;

import java.util.ArrayList;
import java.util.Random;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
        BaiDangAdapter baiDangAdapter;

        GridView gdvDanhSachBaiViet;

        RelativeLayout lot_phai;
        DrawerLayout lot_chinh;


        NguoiDang nguoiDang;
        TextView txvTenNguoiDang;
        ImageView imgAnhProfile;

        BaiDang baiDang;
        ImageView imgBaiDang, imgBaiDang2;
        TextView txvTimBaiDang,txvLuotChiaSe,txvBinhLuanBaiDang,txvNoiDungBaiDang;

        ArrayList<BaiDang> arrBaiDang;
        ArrayList<BaiDang> arrBaiDang2;
        int viTriBaiDang;
        int indexAnh;

        ImageView imgAnhNguoiDung, imgNguoiNoiTieng;
        TextView txvTenNguoiDung, txvTenRutGon, txvLuotDiTheodoi, txvLuotTheoDoi, txvLuotTim;

        FakeData fakeData;
        TextView txvMoTa;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                init();    // thứ tự khởi tạo
                anhXa();
                setUp();
                setClick();
                chonNoiDungHienThiBaiDang();


       }
        ///----- hàm khởi tạo ( hiện lên UI )
        private void init(){
                viTriBaiDang = 1;
                arrBaiDang = new ArrayList<>();
                fakeData = new FakeData();
                Random random = new Random();
                for(int i=0; i<10; i++){
                        arrBaiDang.add(fakeData.taoBaiDang());
                }
      //  arrBaiDang2 = new ArrayList<>(); // Tạo ra 1 list hình ảnh trong GridView
      //  int indexAnh = 0;
      //  for(int i=0; i<8; i++) {
      //      BaiDang a = new BaiDang();
      //      //  if (indexAnh==arrAnh2.length){  // ví dụ có 3 ảnh mà lấy ảnh thứ 4 thì trả về 0 1 2 ...
      //      //          indexAnh=0      ;  // lấy ảnh theo thứ tự  0 1 2 3 4
      //      //  }
      //      //  a.anh = arrAnh2[indexAnh];
      //      //  indexAnh++;
      //      arrBaiDang2.add(fakeData.taoGrvBaiDang());
      //  }

        }
        // anhXa chứa các biến(Image,Grid,Relate,... lấy ra các file thiết kế
        private void anhXa(){
                gdvDanhSachBaiViet = findViewById(R.id.gdvDanhSachBaiViet);  // Cú pháp đặt 
                lot_phai = findViewById(R.id.lot_phai);
                lot_chinh  = findViewById(R.id.lot_chinh);
                imgBaiDang = findViewById(R.id.imgBaiDang);
                txvTenNguoiDang = findViewById(R.id.txvTenNguoiDang);
                imgAnhProfile = findViewById(R.id.imgAnhProfile);
                txvLuotChiaSe = findViewById(R.id.txvLuotChiaSe);
                txvTimBaiDang = findViewById(R.id.txvTimBaiDang);
                txvBinhLuanBaiDang= findViewById(R.id.txvBinhLuanBaiDang);
                txvNoiDungBaiDang = findViewById(R.id.txvNoiDungBaiDang);
                imgAnhNguoiDung = findViewById(R.id.imgAnhNguoiDung);
                txvTenNguoiDung = findViewById(R.id.txvTenNguoiDung);
                txvTenRutGon = findViewById(R.id.txvTenRutGon);
                txvLuotDiTheodoi = findViewById(R.id.txvLuotDiTheodoi);
                txvLuotTheoDoi = findViewById(R.id.txvLuotTheoDoi);
                txvLuotTim = findViewById(R.id.txvLuotTim);
                imgNguoiNoiTieng = findViewById(R.id.imgNguoiNoiTieng);
                txvMoTa = findViewById(R.id.txvMoTA);
                imgBaiDang2 = findViewById(R.id.imgBaiDang2);
        }
        // hiển thị lên thông tin ngay khi vào app
        private void setUp(){

        }
        // setup các sự kiện k có sẵn
        private void setClick(){

                                gdvDanhSachBaiViet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  // code tự sinh
                                        BaiDang b = arrBaiDang2.get(position);
                                        hienThiBaiDang2(b); //hienThiAnh(imgBaiDang,b.anh);  // tạo 1 hienthibaidang, hienthithongtin 2
                                        hienThiThongTinNguoiDang2(b.nguoiDang);
                                        lot_chinh.closeDrawer(lot_phai);
                                        viTriBaiDang = position; // đặt vị trí position
                                        arrBaiDang.clear(); // xóa sạch list ảnh 1
                                        arrBaiDang.addAll(arrBaiDang2);// thêm list2
                                        makeText(MainActivity.this,"Ảnh "+ position, LENGTH_SHORT).show();// hiện thông báo

                                }
                        });
   //      imgBaiDang.setOnClickListener(new View.OnClickListener() {
   //          @Override
   //          public void onClick(View v) {
   //           viTriBaiDang++;
   //           if (viTriBaiDang==arrBaiDang.size()) {// nếu quá số lượng "Size" trong arrBaiDang => hiện ra "Toast"
   //                   Toast.makeText(MainActivity.this, "Đã hết", Toast.LENGTH_SHORT).show();
   //                   return ;
   //           }
   //                    chonNoiDungHienThiBaiDang();
   //      }
   //  });
            imgBaiDang.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()){
                                    case MotionEvent.ACTION_DOWN:
                                            x1 = event.getX();
                                            y1 = event.getY();
                                           return true;
                                    case MotionEvent.ACTION_UP:
                                            x2 = event.getX();
                                            y2 = event.getY();
                                            float deltaX = x1 - x2 ;
                                            float deltaY = y1 - y2 ;
                               if(Math.abs(y1 - y2)>phamViChoPhep) {
                                       if (Math.abs(deltaX) > phamViChoPhep) {
                                               // trai  phai
                                               if (deltaX < 0) {
                                                       lot_chinh.closeDrawer(lot_phai);
                                                       // Toast.makeText(MainActivity.this,"Vuot Phai",Toast.LENGTH_SHORT).show();
                                                       return true;
                                               }
                                               if (deltaX > 0) {
                                                       //Toast.makeText(MainActivity.this,"Vuot Trai",Toast.LENGTH_LONG).show();
                                                       lot_chinh.openDrawer(lot_phai);
                                                       return true;
                                               }

                                       }
                                       if (Math.abs(deltaY) > phamViChoPhep) {
                                               // top or down
                                               if (deltaY < 0) {
                                                       //Toast.makeText(MainActivity.this,"Vuot Xuong",Toast.LENGTH_SHORT).show();
                                                   imgBaiDang.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.tren_xuongduoii));// nuoi duoi nhau khi vuot xuong
                                                   imgBaiDang2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.trenxuong_duoi2));
                                                   //Thoi gian dem nguoc : milli : dem nguoc , coutDown : kieu dem nguoc , time1 tao ra 1 file value chua 1 thong so nhat dinh;
                                                   new CountDownTimer(MainActivity.this.getResources().getInteger(R.integer.time1), 100) {

                                                       @Override
                                                       //Thoi gian dem nguoc - kieu dem nguoc : 1000 - 100 va` co the setUp su kien trong day
                                                       public void onTick(long millisUntilFinished) {

                                                       }

                                                       @Override
                                                       //
                                                       public void onFinish() {
                                                           xemBaiDang(-1);
                                                       }
                                                   }.start();
                                                       return true;

                                               }
                                               if (deltaY > 0) {
                                                   //Toast.makeText(MainActivity.this,"Vuot Len",Toast.LENGTH_SHORT).show();
                                                   // start Animation ben anim
                                                   imgBaiDang.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.duoi_lentren)); // nuoi duoi nhau khi vuot len
                                                   imgBaiDang2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.duoi_lentren2));
                                                   //Thoi gian dem nguoc : milli : dem nguoc , coutDown : kieu dem nguoc
                                                   new CountDownTimer(MainActivity.this.getResources().getInteger(R.integer.time1), 50) {

                                                       @Override
                                                       //Thoi gian dem nguoc - kieu dem nguoc : 1000 - 100 va` co the setUp su kien trong day
                                                       public void onTick(long millisUntilFinished) {

                                                       }

                                                       @Override
                                                       //
                                                       public void onFinish()   {
                                                           xemBaiDang(1);

                                                       }
                                                   }.start();
                                                   };
                                                   return true;
                                               }
                               }break;
                                default:
                              break;
                            }
                            return false;
                    }
            });
        }
        float x1,x2;
        float y1,y2;
        int phamViChoPhep=100;
    private void xemBaiDang(int i) {

        viTriBaiDang = i + viTriBaiDang;

        if(viTriBaiDang+1>=arrBaiDang.size()){
            urlHienThi="";
        }else if(viTriBaiDang<0){/// 1  2 3 4 5
            urlHienThi="";
        }else{
            if(i>0) {
                urlHienThi = arrBaiDang.get(viTriBaiDang + 1).anh;
            }
                else {
                urlHienThi= arrBaiDang.get(viTriBaiDang-1).anh;
            }
        }



        if (viTriBaiDang >= arrBaiDang.size()) {
            viTriBaiDang = arrBaiDang.size() - 1;
            Toast.makeText(MainActivity.this, "Đã hết bài đăng", Toast.LENGTH_SHORT).show();
            return;
        }
        if (viTriBaiDang < 0) {
            viTriBaiDang = 0;
            Toast.makeText(MainActivity.this, "Đã hết bài đăng", Toast.LENGTH_SHORT).show();
            return;
        }
        chonNoiDungHienThiBaiDang();
    }
    String urlHienThi="";

        private void chonNoiDungHienThiBaiDang(){  // hiển thi bài đăng hiện lên màn hình khi vào app
               // Random r = new Random();
                baiDang =  arrBaiDang.get(viTriBaiDang) ;// arrBaiDang.get(r.nextInt(arrBaiDang.size())) random ảnh k theo vị trí
                nguoiDang = baiDang.nguoiDang;
                hienThiThongTinNguoiDang();
                hienThiBaiDang();
        }


        // Các hàm xử lí thông tin
        public void hienThiThongTinNguoiDang(){

                txvTenNguoiDang.setText(nguoiDang.ten);
                hienThiAnh(imgAnhProfile,nguoiDang.anh); // hiện thị ảnh profile qua class NguoiDang
        }
        public void hienThiThongTinNguoiDang2( NguoiDang n){ // hiển thị thông tin người đăng
                txvTenNguoiDang.setText(n.ten);
                hienThiAnh(imgAnhProfile,n.anh); // hiện thị ảnh Profile qua 1 nguoiDang n
        }
        public void hienThiAnh(ImageView i , String url){
                Glide.with(this).load(url).into(i); // tạo 1 cú pháp hiện thị ảnh để sử dụng cho tiện
        }

        public void hienThiBaiDang(){
                if(urlHienThi.length()>0){
                   hienThiAnh(imgBaiDang2,urlHienThi);
                }
                hienThiAnh(imgBaiDang,baiDang.anh);
                txvTimBaiDang.setText(baiDang.luotThich);  //set Text
                txvBinhLuanBaiDang.setText(baiDang.luotBinhLuan);
                txvLuotChiaSe.setText(baiDang.luotChiaSe);
                txvNoiDungBaiDang.setText(baiDang.noiDungBaiDang);
        }

        public void hienThiBaiDang2(BaiDang n){
                hienThiAnh(imgBaiDang,n.anh);
                txvTimBaiDang.setText(n.luotThich);
                txvBinhLuanBaiDang.setText(n.luotBinhLuan);
                txvLuotChiaSe.setText(n.luotChiaSe);
                txvNoiDungBaiDang.setText(n.noiDungBaiDang);
        }
        ///----- Các hàm Click có sẵn (bên activity : onClick )
        public void doianh(View view){

        }
        public void hienThiThongTinNguoiDung() {
            txvTenRutGon.setText(nguoiDang.ten);
            hienThiAnh(imgAnhNguoiDung,baiDang.anh);
            txvTenNguoiDung.setText(nguoiDang.ten);
            txvLuotTheoDoi.setText(""+nguoiDang.luotTheoDoi);
            txvLuotDiTheodoi.setText(""+nguoiDang.luotDiTheoDoi);
            txvLuotTim.setText("" + nguoiDang.luotTim);
            txvMoTa.setText(""+nguoiDang.moTa);

            arrBaiDang2 = nguoiDang.arrBaiDangRieng;
            gdvDanhSachBaiViet.setAdapter(baiDangAdapter);
            baiDangAdapter = new BaiDangAdapter(this, 0 , arrBaiDang2); // set Adapter lên GridView bài đăng

            if(nguoiDang.nguoiNoiTieng== true){
                {imgNguoiNoiTieng.setVisibility(View.VISIBLE);}
            }else{
                imgNguoiNoiTieng.setVisibility(View.INVISIBLE);
            } 
            
        }

        public void dongTrangCaNhan(View view) {
                lot_chinh.closeDrawer(lot_phai); //đóng
        }
        public void moTrangCaNhan(View view) {
                hienThiThongTinNguoiDung();
                lot_chinh.openDrawer(lot_phai); // mở
        }

}