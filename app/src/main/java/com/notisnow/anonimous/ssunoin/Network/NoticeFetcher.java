package com.notisnow.anonimous.ssunoin.Network;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.notisnow.anonimous.ssunoin.Model.Notice.NoticeObj;
import com.notisnow.anonimous.ssunoin.StaticField.Data;
import com.notisnow.anonimous.ssunoin.UI.Notice.NoticeContract;
import com.notisnow.anonimous.ssunoin.Utils.BaseApplication;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class NoticeFetcher {
    private String url;
    private int position;
    RequestQueue queue;
    NoticeContract.Presenter mPresenter;
    public NoticeFetcher(int position) {
        Log.d("fetcher init","init");
        this.position = position;

    }
  /*  public void initFetch(final int pos,final NoticeByMajorContract.View v){
       final  ArrayList<NoticeObj> list=new ArrayList<>();
        url = Data.getDepartmentOf().get(pos).getUrl();
        queue= BaseApplication.getRequestQueue();
        StringRequest request = new StringRequest(Request.Method.GET, url +1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document = Jsoup.parse(response);
                Elements elements = document.select(".bbs-list").select("tbody").select("tr").not(".trNotice");

               // elements.remove(0); //목차 제거
                for (int i = 0; i < elements.size(); i++) {
                        list.add(query(pos, elements.get(i).select("td")));
                        Log.d("elements", elements.get(i).select("td").html().toString());
                }

                Intent intent =new Intent(((NoticeByMajorFragment)v).getActivity().getApplicationContext(),NoticeActivity.class);
                intent.putExtra("majorId",pos);
                intent.putExtra("arrayList",list);
                ((NoticeByMajorFragment) v).getActivity().startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error","error");
            }
        });
        queue.add(request);

    }
    *this Method was Deprecated.
    */

    com.android.volley.Response.Listener<String> stringListener;
    public void setPresenter(NoticeContract.Presenter presenter){
        this.mPresenter=presenter;
    }
    public void getObjList(int i, final ArrayList<NoticeObj> list, final RecyclerView.Adapter adapter) {
        url = Data.getDepartmentOf().get(position).getUrl();
        queue= BaseApplication.getRequestQueue();
        StringRequest request = new StringRequest(Request.Method.GET, url +i, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document = Jsoup.parse(response);
                Elements elements = document.select(".bbs-list").select("tbody").select("tr").not(".trNotice");
                //elements.remove(0); //목차 제거
                for (int i = 0; i < elements.size(); i++) {

                   list.add(query(position, elements.get(i).select("td")));

                }
                mPresenter.setFooterCount(false);
                adapter.notifyDataSetChanged();
                mPresenter.fetchSucced();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error","error");
                mPresenter.setFooterCount(false);
                adapter.notifyDataSetChanged();
                return;
            }
        });
        queue.add(request);

    }

    private NoticeObj query(int pos, Elements element) {
        switch (pos) {
            case 0:
                return KQuery(element);
            case 1:
                return EQuery(element);
            case 2:
                return FQuery(element);
            case 3:
                return GQuery(element);
            case 4:
                return JQuery(element);
            case 5:
                return CQuery(element);
            case 6:
                return HQuery(element);
            case 7:
                return PQuery(element);
            default:
                return null;
        }
    }

    private NoticeObj KQuery(Elements element) {
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(4).text());
        if (element.get(2).html().equals("&nbsp;")) obj.setContainFile(false);
        else obj.setContainFile(true);
        return obj;
    }

    private NoticeObj JQuery(Elements element) {
       // Log.d("일어일문 파일첨부?",element.get(2).html());
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(4).text());
        if (element.get(2).html().equals("&nbsp;")) obj.setContainFile(false);
        else obj.setContainFile(true);
        return obj;
    }

    private NoticeObj CQuery(Elements element) {
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(3).text());
        if (element.get(2).html().equals("&nbsp;")) obj.setContainFile(false);
        else obj.setContainFile(true);
        return obj;
    }

    private NoticeObj FQuery(Elements element) {
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(3).text());

        return obj;
    }

    private NoticeObj GQuery(Elements element) {
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(0).select("a").text());
        obj.setUrl(element.get(0).select("a").attr("href"));
        obj.setDate(element.get(1).text());

        return obj;
    }

    private NoticeObj EQuery(Elements element) {
        NoticeObj obj = new NoticeObj();

        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(4).text());
        if (element.get(2).html().equals("&nbsp;")) obj.setContainFile(false);
        else obj.setContainFile(true);
        return obj;
    }

    private NoticeObj HQuery(Elements element) {
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(4).text());
        if (element.get(2).html().equals("&nbsp;")) obj.setContainFile(false);
        else obj.setContainFile(true);
        return obj;
    }

    private NoticeObj PQuery(Elements element) {
        NoticeObj obj = new NoticeObj();
        obj.setTitle(element.get(1).select("a").text());
        obj.setUrl(element.get(1).select("a").attr("href"));
        obj.setDate(element.get(4).text());
        if(element.get(2).html().equals("&nbsp;"))obj.setContainFile(false);
        else obj.setContainFile(true);
        return obj;
    }

}
