package com.hejunlin.imooc_supervideo.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.TextView;

import com.hejunlin.imooc_supervideo.R;
import com.hejunlin.imooc_supervideo.base.BaseActivity;
import com.hejunlin.imooc_supervideo.common.CommonActivity;
import com.hejunlin.imooc_supervideo.live.LiveActivity;
import com.hejunlin.imooc_supervideo.model.Album;
import com.hejunlin.imooc_supervideo.model.AlbumList;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends CommonActivity {

    @Override
    public String getTitleText() {
        return getResources().getString(R.string.favorite_title);
    }

    @Override
    public String getEmptyText() {
        return getResources().getString(R.string.favorite_empty);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String getTableName() {
        return "favorite";
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, FavoriteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }

}
