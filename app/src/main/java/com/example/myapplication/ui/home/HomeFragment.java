package com.example.myapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.myapplication.ui.GridIcon;
import com.example.myapplication.utils.CommonBaseAdapter;
import com.example.myapplication.R;
import com.example.myapplication.utils.ViewHolder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {
    private final String TAG = "HomeFragment";
    ArrayList<GridIcon> objs = new ArrayList<>();
    private GridView gridView;
    private ViewGroup viewGroup;
    CommonBaseAdapter<GridIcon> objCommonBaseAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = root.findViewById(R.id.list_view);
        viewGroup = container;
        initView();
        ininData();
        return root;
    }

    public void del(){
        objCommonBaseAdapter.remove(objCommonBaseAdapter.getCount()-1);
    }

    public void add() {
        GridIcon gridIcon = new GridIcon();
        gridIcon.setTitle("小黄人");
        gridIcon.setImgSrc("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577634374229&di=88a10eca70d62a512e83da8f3dd749aa&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fphotos%2F40500000%2Fnewclubimage-despicable-me-minions-40532353-5038-4325.jpg");
        objCommonBaseAdapter.add(gridIcon);
    }

    private void initView() {
        objCommonBaseAdapter =
                new CommonBaseAdapter<GridIcon>(viewGroup.getContext(), objs, R.layout.me_item) {
                    @Override
                    public void bindView(ViewHolder viewHolder, GridIcon obj) {
                        RelativeLayout convertView = ((RelativeLayout) viewHolder.getConvertView());
                        WindowManager windowManager = (WindowManager) context.getApplicationContext()
                                .getSystemService(Context.WINDOW_SERVICE);
                        int width = windowManager.getDefaultDisplay().getWidth() / 4;
                        convertView.setLayoutParams(new RelativeLayout.LayoutParams(width, width));
                        TextView view = (TextView) viewHolder.getView(R.id.item_text);
                        view.setText(obj.getTitle());
                        ImageView imageView = (ImageView) viewHolder.getView(R.id.item_image);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        layoutParams.width = (int) (width * 0.8);
                        layoutParams.height = (int) (width * 0.8);
                        imageView.setLayoutParams(layoutParams);
                        Glide.with(viewGroup).load(obj.getImgSrc())
                                .into(imageView);
                        GridIcon.Action action = obj.getAction();
                        if (action != null) {
                            bindAction(convertView, action);
                        }
                    }

                    private void bindAction(RelativeLayout convertView, GridIcon.Action action) {
                        Log.i(TAG, "bindAction: "+convertView+" on " + new Gson().toJson(action));
                        convertView.setOnClickListener(v -> {
                            switch (action.getType()) {
                                case GridIcon.Action.ACTION_TYPE_SHOW:
                                    Toast.makeText(convertView.getContext(), action.getShowMsg(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "bindAction: " + action.getShowMsg() + " : ");
                                    break;
                                case GridIcon.Action.ACTION_TYPE_METHOD:
                                    Log.d(TAG, "bindAction: " + action.getMethod() + " : " + action.getMethodParam());
                                    HomeFragment homeFragment = HomeFragment.this;
                                    try {
                                        Method method = homeFragment.getClass().getMethod(action.getMethod());
                                        method.invoke(homeFragment);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        });
                    }
                };
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                GridIcon item = objCommonBaseAdapter.getItem(position);
//                Toast toast = Toast.makeText(viewGroup.getContext(), item.getTitle(), Toast.LENGTH_SHORT);
//                toast.show();
//                GridIcon gridIcon = new GridIcon();
//                gridIcon.setTitle("小黄人");
//                gridIcon.setImgSrc("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577634374229&di=88a10eca70d62a512e83da8f3dd749aa&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fphotos%2F40500000%2Fnewclubimage-despicable-me-minions-40532353-5038-4325.jpg");
//                objCommonBaseAdapter.add(gridIcon);
//            }
//        });
        gridView.setAdapter(objCommonBaseAdapter);
    }

    private void ininData() {
        RequestQueue requestQueue = Volley.newRequestQueue(viewGroup.getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("https://qqhxj.oss-cn-beijing.aliyuncs.com/test/item.json", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
                objs = gson.fromJson(response.toString(), new TypeToken<ArrayList<GridIcon>>() {
                }.getType());
                objCommonBaseAdapter.addALl(objs);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}