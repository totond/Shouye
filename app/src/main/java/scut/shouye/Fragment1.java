/**
 * 
 */
package scut.shouye;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class Fragment1 extends Fragment implements MyItemClickListener {
	private RecyclerView Rv;
	private ArrayList<HashMap<String,Object>> listItem;
	private MyAdapter myAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_item1, null);
		Rv = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		initData();
		initView();
		return view;
	}

	public void initData(){
		listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
		for (int i = 0; i < 100; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemTitle", "第" + i + "行");
			map.put("ItemText", "这是第" + i + "行");
			map.put("ItemImage",R.mipmap.ic_launcher);
			listItem.add(map);
		}
	}
	public void initView(){
		LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());


		myAdapter = new MyAdapter(getActivity().getApplicationContext(),listItem);
		myAdapter.setOnItemClickListener(this);
		Rv.addItemDecoration(new DividerItemDecoration(getActivity().getApplicationContext(), layoutManager.getOrientation()));
		Rv.setLayoutManager(layoutManager);
		Rv.setHasFixedSize(true);
		Rv.setAdapter(myAdapter);

	}

	@Override
	public void onItemClick(View view, int postion) {
		System.out.println("点击了第"+postion+"行");
		Toast.makeText(getActivity().getApplicationContext(), (String)listItem.get(postion).get("ItemText"), Toast.LENGTH_SHORT).show();
	}

}
