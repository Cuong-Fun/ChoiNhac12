package com.manhcuong.choinhac.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;
import com.manhcuong.choinhac.R;
import com.manhcuong.choinhac.object.BaiDang;

import java.util.ArrayList;
import java.util.List;


public class BaiDangAdapter extends ArrayAdapter {
    public ArrayList<BaiDang> arrBaiDang;
    private Context ct;

    public BaiDangAdapter(@NonNull Context context, int resource, @NonNull List<BaiDang> objects) { // code tự sinh câu lệnh
        super(context, resource, objects);
        ct = context;  // context có nhiều tác dụng quan trọng
        arrBaiDang = new ArrayList<>(objects);
    }

    @NonNull
    @Override // convertView: Lấy Hình Ảnh rồi đổ xuống inflater rồi sau đó đẩy lên arrBaiDang
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) { // code tự sinh câu lệnh
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bai_dang, null);
        }
            BaiDang b = arrBaiDang.get(position);  // position : get dữ liệu , chạy lần lượt từ đầu đến cuối, tự thêm xóa khi vuốt màn hình android
            ImageView img = convertView.findViewById(R.id.imgBaiDang); // 3 câu lệnh có td lấy url ảnh dựa vào setting file thiết kế truyền lên arrBaiDang
            Glide.with(ct).load(b.anh).into(img);

            TextView tvx = convertView.findViewById(R.id.txvHeart); // tương tự
            tvx.setText(b.luotThich);
            return convertView; //
    }
}

