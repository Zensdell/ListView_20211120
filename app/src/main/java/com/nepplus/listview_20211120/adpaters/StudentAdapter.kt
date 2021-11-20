package com.nepplus.listview_20211120.adpaters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nepplus.listview_20211120.R
import com.nepplus.listview_20211120.datas.StudentData
//스튜던트 어댑터의 하위 데이터를 받아옵니다, ex)StudentData  어디서 mContext어떤 모양으로?resId 어떤 목록을mList?
class StudentAdapter(
    val mContext: Context,
    val resId:Int,
    val mList : ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext,resId,mList){

//        Adapter 역할: xml + 데이터 클래스 자료 조합.

//        xml파일을 - >이 어댑터 코드에서 끌어다 사용하게 도와줌
        val mInflater = LayoutInflater.from(mContext)

//        xml + 데이터 조합 -> 위치에 ㅂ뿌려주는 함수 (ArrayAdapter 제공) -> 커스터마이징 (함수 오버라이딩)
//        position 위치 0,1,2,.... convertView 메모리 줄이는 용도
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        
        var tempRow = convertView
    
        if(tempRow == null){
            tempRow = mInflater.inflate(R.layout.student_list_item,null)
        }

//     xml -> row 변수에 담아두자.
        val row = tempRow!!
//    row를 실제 데이터를 가공해주고
//      근거 데이터를 가져오자

        val data = mList[position]
//    뿌려질 ui들을 row 내부에서 찾아오자.

        val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)

//      ui데이터에 필요한 변수 추출 반영
        txtStudentName.text = data.name


//     row에 담긴 xml을 화면에 뿌려주게 내보내자
        return row

    }





}