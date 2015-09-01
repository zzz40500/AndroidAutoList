# AndroidAutoList
自动更新列表的AutoList

 在 Android 开发是否有这样的场景:
  界面 A 有一个列表.点击列表跳转到列表 Item 的详情界面B.在这个详情界面我们可能会有许多操作,修改或者删除,或者在另外界面C 中新增了一个 Item, 点击返回我们要返回到界面 A, 这时候我们出于用户体验的考虑不会在网络请求数据,而是手动的对数据进行增删改.

之前我的做法是用事件分发总线(otto, 或者 eventBus).在 Fragment 中或者 Activity 中注册观察者.无形中给 Fragment 或者 Activity 中正在代码量.
现在有个新的做法.将观察者注册到数据源中.增删改交给数据源处理.将一些过滤条件放在 Activtity 中或者 Fragment 中.
这个我编写 AutoList 出现的初衷.


使用:
把会有增删改的数据源的实体类继承 AutoData 类
实现getIdentifies 这个方法.返回的是这个类的唯一标识.
~~~
public class ManEntity extends AutoData  {

    /**
     * name : 王五
     * age : 15
     * height : 140cm
     */

    public int id;
    public String name;
    public int age;
    public String height;
    public ManEntity() {
    }

    @Override
    public String getIdentifies() {
        return id+"";
    }
 }


~~~

在主 Acitivity 中使用也是特别的方便.

~~~
public class MansActivity extends AppCompatActivity {

    private AutoList<ManEntity> mAutoList=new AutoList<ManEntity>();

    private BaseAdapter adapter;
    private  int mIndex=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //模拟数据
        initData();
        adapter=new ManAdapter(this,mAutoList);
      
        ListView lv= (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
}
~~~
NOTE: 这里可能没有体现:我在适配器中调用 `AutoList.setup(this);`
        `AutoList.setAdapter(adapter);`这两个方法.因为这个可以很容易的集成在适配器中,你可以自行封装,也可以使用我提供的适配器类库 fork 自[CommonAdapter](https://github.com/tianzhijiexian/CommonAdapter) 改成适合自己的样子.(废话太多了)

Item 增删改操作:
~~~
在任意界面 
新增通知:
mManEntity.appleAction(this, AutoData.Action.Add).post();
修改通知:
mManEntity.appleAction(this, AutoData.Action.Update).post();
删除通知:
mManEntity.appleAction(this, AutoData.Action.Delete).post();
~~~

过滤操作:
~~~

mAutoList.setActionHandler(new AutoList.ActionHandler<AutoData>() {
    @Override
    public boolean beforeHandleAction(AutoData a) {

        //  a.action action 操作 Add 新增 Delete 删除 Update 更新 Custom 自定义无默认动作
        // a.formObject     表明从哪里发送过来的,可以当过滤条件.
        
       // true 表示动作已被处理,不会执行默认操作 false 执行默认操作
        return false;

    }

    @Override
    public void afterHandleAction(AutoData a) {
      // 已处理消息回调处.
    }
});
~~~
使用这个可以很方便进行条件定制.



![AutoList.gif](http://upload-images.jianshu.io/upload_images/166866-f85a1d7c207fcfe3.gif?imageMogr2/auto-orient/strip)

