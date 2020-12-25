package com.manhcuong.choinhac.object;

import java.util.ArrayList;
import java.util.Random;

public class FakeData
{
    String arrAnh[] = new String[]{
            "https://www.elleman.vn/wp-content/uploads/2019/05/20/1-buc-anh-dep-ca-voi.png",
            "https://www.elleman.vn/wp-content/uploads/2019/05/20/2-buc-anh-dep-me-con-ho.png",
            "https://www.elleman.vn/wp-content/uploads/2019/05/20/3-buc-anh-dep-chua-Chureito.png",
            "https://www.elleman.vn/wp-content/uploads/2019/05/20/4-buc-anh-dep-hinh-gau-truc.jpg",
            "https://www.elleman.vn/wp-content/uploads/2019/05/20/5-buc-anh-dep-cua-thanh-pho.jpg",
            "https://i.pinimg.com/236x/3f/da/fa/3fdafa335788e529be11b9f199cfe553.jpg",
            "https://i.pinimg.com/236x/5f/0e/e0/5f0ee0cbda69b948295abe6fbc553d19.jpg",
            "https://i.pinimg.com/236x/76/05/64/76056430ebe5c2009a97de1274c6a9fb.jpg",
            "https://i.pinimg.com/236x/d8/00/af/d800af86cff120848c44cc00fffed90a.jpg",
            "https://i.pinimg.com/236x/d6/5f/db/d65fdb775baa3a1f97f3f0eb5938a72d.jpg"
    };
    String arrNoiDung[] = new String[]{
            "apple",
            "butcher",
            "concert",
            "dark",
            "english"
    };
    String arrAnh2[] = new String[]{
            "https://i.pinimg.com/236x/3f/da/fa/3fdafa335788e529be11b9f199cfe553.jpg",
            "https://i.pinimg.com/236x/5f/0e/e0/5f0ee0cbda69b948295abe6fbc553d19.jpg",
            "https://i.pinimg.com/236x/76/05/64/76056430ebe5c2009a97de1274c6a9fb.jpg",
            "https://i.pinimg.com/236x/d8/00/af/d800af86cff120848c44cc00fffed90a.jpg",
            "https://i.pinimg.com/236x/d6/5f/db/d65fdb775baa3a1f97f3f0eb5938a72d.jpg",

    };
    String arrTen[] = new String[]{
            "KiMoChi",
            "Xu Xu",
            "1 Chạm là Đau",
            "LapLai_TinhYeu",
            "FoReVer",
            "OLeHap"

    };
    Random random = new Random();
    public BaiDang taoBaiDang () {


        BaiDang a = new BaiDang();
        a.anh = arrAnh[random.nextInt(arrAnh.length)];

        a.luotThich = random.nextInt(400)+"k" ;
        a.luotChiaSe= random.nextInt(400)+"k"; // random lượt thích,...
        a.luotBinhLuan= random.nextInt(500)+"k";

        a.noiDungBaiDang=  "..."  ;//arrNoiDung[random.nextInt(arrNoiDung.length)] ;

        NguoiDang n = new NguoiDang();  // tạo 1 người đăng n để random ảnh Profile
        n.ten =  arrTen[random.nextInt(arrTen.length)];  //""+(char)(random.nextInt(200));
        n.anh =   a.anh; //arrAnh[random.nextInt(arrAnh.length)];
        n.tenRutGon =  arrTen[random.nextInt(arrTen.length)];
        n.nguoiNoiTieng = random.nextBoolean();
        n.luotTim = random.nextInt(2000);
        n.luotTheoDoi = random.nextInt(2000);
        n.luotDiTheoDoi = random.nextInt(2000);
        n.moTa = ""+(char)(random.nextInt(200)) ;
        n.arrBaiDangRieng = new ArrayList<BaiDang>(taoGrvBaiDang(n));
        a.nguoiDang=n;
        return a;
    }

        private ArrayList<BaiDang> taoGrvBaiDang(NguoiDang n){
            ArrayList<BaiDang> taoarrGrvBaiDang = new ArrayList<>();
            int  t = 10 ;//+ random.nextInt(10);
            for (int i = 0; i <t ; i++){
                BaiDang a = new BaiDang();
                a.anh = arrAnh[random.nextInt(arrAnh.length)];

                a.luotThich = random.nextInt(400)+"k";
                a.luotChiaSe= random.nextInt(400)+"k"; // random lượt thích,...
                a.luotBinhLuan= random.nextInt(500)+"k";

                a.noiDungBaiDang=  "..."  ;//arrNoiDung[random.nextInt(arrNoiDung.length)] ;

                taoarrGrvBaiDang.add(a);
                a.nguoiDang=n;
            }
            return taoarrGrvBaiDang;
        }
}
