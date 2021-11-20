package com.nepplus.listview_20211120.adpaters

import android.content.Context
import android.widget.ArrayAdapter
import com.nepplus.listview_20211120.datas.StudentData
//스튜던트 어댑터의 하위 데이터를 받아옵니다, ex)StudentData  어디서 mContext어떤 모양으로?resId 어떤 목록을mList?
class StudentAdapter(
    val mContext: Context,
    val resId:Int,
    val mList : ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext,resId,mList){
}