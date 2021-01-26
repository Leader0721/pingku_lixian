package com.example.ckxt_yezhan.ruku.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.ckxt_yezhan.database.MyDatabase;
import com.example.ckxt_yezhan.database.table.RuKuDMXTable;
import com.example.ckxt_yezhan.database.table.RuKuDMXTable_Table;
import com.example.ckxt_yezhan.ruku.dto.RuKuDMXDto;
import com.example.ckxt_yezhan.ruku.query.RuKuDMXQueryInfo;
import com.example.ckxt_yezhan.utils.LogUtils;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.util.List;

public class RuKuDMXDao {
    private Context context;
    public RuKuDMXDao(Context context){
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
    public void insert(final RuKuDMXTable ruKuDMXTable ){
        DatabaseDefinition database = FlowManager.getDatabase(MyDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                ruKuDMXTable.insert();
            }
        }).success(new RuKuDMXDao.OnSuccess()).error(new RuKuDMXDao.OnError()).build();
        transaction.execute();
    }

    public List<RuKuDMXDto> queryRuKuDMX(RuKuDMXQueryInfo ruKuDMXQueryInfo){
      if(ruKuDMXQueryInfo.getId_rukudhzckxt()==null){
          ruKuDMXQueryInfo.setId_rukudhzckxt("");
        }
        if(ruKuDMXQueryInfo.getChaXunTJ()==null){
            ruKuDMXQueryInfo.setChaXunTJ("");
        }

        List<RuKuDMXDto> list = SQLite.select(
        )
                .from(RuKuDMXTable.class)
                .where(RuKuDMXTable_Table.rukudid.eq(ruKuDMXQueryInfo.getId_rukudhzckxt()))
                .and(RuKuDMXTable_Table.wuzimc.like("%"+ruKuDMXQueryInfo.getChaXunTJ()+"%"))
                .queryCustomList(RuKuDMXDto.class);
        return list;
    }


    public void updateYiyanshousj(final RuKuDMXQueryInfo ruKuDMXQueryInfo ){
        DatabaseDefinition database = FlowManager.getDatabase(MyDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                SQLite.update(RuKuDMXTable.class)
            .set(RuKuDMXTable_Table.yiyanshousl.eq(ruKuDMXQueryInfo.getYiyanshousj()))
            .where(RuKuDMXTable_Table.id_rukudmxckxt.eq(ruKuDMXQueryInfo.getId_rukudmxckxt()))
            .execute();
            }
        }).success(new RuKuDMXDao.OnSuccess()).error(new RuKuDMXDao.OnError()).build();
        transaction.execute();
    }
    public void updateYishangjiasl(final RuKuDMXQueryInfo ruKuDMXQueryInfo ){
        DatabaseDefinition database = FlowManager.getDatabase(MyDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                SQLite.update(RuKuDMXTable.class)
                        .set(RuKuDMXTable_Table.yishangjiasl.eq(ruKuDMXQueryInfo.getYishangjiasl()))
                        .where(RuKuDMXTable_Table.id_rukudmxckxt.eq(ruKuDMXQueryInfo.getId_rukudmxckxt()))
                        .execute();
            }
        }).success(new RuKuDMXDao.OnSuccess()).error(new RuKuDMXDao.OnError()).build();
        transaction.execute();
    }
}
