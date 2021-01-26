package com.example.ckxt_yezhan.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @Description:如果以后要修改任意表的结构，为避免与旧版本数据库冲突一定要修改版本号，且保证版本号只升不降
 * @Prject:https://zhuanlan.zhihu.com/p/60264972         https://www.jianshu.com/p/9fe0e179f5bf
 * https://agrosner.gitbooks.io/dbflow/content/QueryModels.html
 *
 *
 * @Package: com.example.ckxt_pingku.database
 * @author: Edwin
 * @date: 2020/12/30 0030   上午 9:50
 * @Copyright: 个人版权所有
 * @Company:lxt
 * @version: 1.0.0
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    //数据库名称
    public static final String NAME = "ckxt";
    //数据库版本号
    public static final int VERSION = 1;
}
