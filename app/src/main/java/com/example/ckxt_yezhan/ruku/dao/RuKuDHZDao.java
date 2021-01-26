package com.example.ckxt_yezhan.ruku.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.ckxt_yezhan.database.MyDatabase;
import com.example.ckxt_yezhan.database.table.RuKuDHZTable;
import com.example.ckxt_yezhan.database.table.RuKuDHZTable_Table;
import com.example.ckxt_yezhan.ruku.dto.RuKuDHZDto;
import com.example.ckxt_yezhan.ruku.query.RuKuDHZQueryInfo;
import com.example.ckxt_yezhan.utils.LogUtils;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.util.List;

public class RuKuDHZDao {
    private Context context;
    public RuKuDHZDao(Context context){
        this.context = context;
    }
    class OnSuccess implements Transaction.Success {

        @Override
        public void onSuccess(Transaction transaction) {
            //  Log.d(DB, "成功");
            // Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        }
    }

    class OnError implements Transaction.Error {
        @Override
        public void onError(Transaction transaction, Throwable error) {
            // Log.d(DB, "失败");
            Toast.makeText(context, "数据库操作失败，事务回滚，请检查", Toast.LENGTH_SHORT).show();
            LogUtils.d("数据库操作失败，事务回滚，请检查");
        }
    }
    public void insert(final RuKuDHZTable ruKuDHZTable ){
        DatabaseDefinition database = FlowManager.getDatabase(MyDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                 ruKuDHZTable.insert();
            }
        }).success(new RuKuDHZDao.OnSuccess()).error(new RuKuDHZDao.OnError()).build();
        transaction.execute();
    }
    public void updateZhuangTai(final RuKuDHZQueryInfo ruKuDHZQueryInfo ){
        DatabaseDefinition database = FlowManager.getDatabase(MyDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                SQLite.update(RuKuDHZTable.class)
                        .set(RuKuDHZTable_Table.zhuangtai.eq(ruKuDHZQueryInfo.getZhuangtai()))
                        .where(RuKuDHZTable_Table.id_rukudhzckxt.eq(ruKuDHZQueryInfo.getId_rukudhzckxt()))
                        .execute();
            }
        }).success(new RuKuDHZDao.OnSuccess()).error(new RuKuDHZDao.OnError()).build();
        transaction.execute();
    }
    public List<RuKuDHZDto> queryRuKuDHZ( ){
        List<RuKuDHZDto> list = SQLite.select(

                )
                .from(RuKuDHZTable.class)
                .queryCustomList(RuKuDHZDto.class);
        return list;
    }
}
