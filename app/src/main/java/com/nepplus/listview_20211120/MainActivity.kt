package com.nepplus.listview_20211120

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nepplus.listview_20211120.adpaters.StudentAdapter
import com.nepplus.listview_20211120.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
// 빈바구니를 가져옴 mStudentAdapter 에  StudentAdapter 넣을건데 lateinit란 뜻은 나중에 실제 값을 넣어주겠단 거야
    lateinit var mStudentAdapter : StudentAdapter
//  리스트의 형태가 ArrayList야
    val mStudentList = ArrayList<StudentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(StudentData("구영모",1990,"경기도 부천시"))
        mStudentList.add(StudentData("조경진", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김정난", 1976,"서울시 용산구"))
        mStudentList.add(StudentData("김정환",1981,"서울시 중랑구"))
        mStudentList.add(StudentData("김찬수",1996,"서울시 성북구"))
        mStudentList.add(StudentData("김창배",1993, "서울시 노원구"))
        mStudentList.add(StudentData("성연진",1994,"서울시 성동구"))
        mStudentList.add(StudentData("윤성노",1985,"서울시 중랑구"))
        mStudentList.add(StudentData("최연주",1974,"서울시 성북구"))
// mStudentAdapter에 실제 값 대입 여기 화면에서 student_list_item이 레이아웃의  mStudentList 목록을 뿌려줄거야
        mStudentAdapter = StudentAdapter(this,R.layout.student_list_item, mStudentList)
// xml에  studentListView 있지? 여기에 .adapter해줄건데 그 어댑터를 mStudentAdapter (StudentAdapter)야
        studentListView.adapter = mStudentAdapter

        studentListView.setOnItemClickListener { parent, view, position, id -> 
            
//            position : 몇번째 줄이 눌렸는지 알려줌.
            val clickedStudent = mStudentList[position]

//            Toast.makeText(this, "${clickedStudent.name} 클릭됨", Toast.LENGTH_SHORT).show()

//            화면 이동 Intent 활용.
            val myIntent = Intent(this,ViewStudentDetailActivity::class.java)

            myIntent.putExtra("name", clickedStudent.name)
            myIntent.putExtra("age", clickedStudent.getAgeByYear(2021))
            myIntent.putExtra("address", clickedStudent.address)

            startActivity(myIntent)

        }
        
        studentListView.setOnItemLongClickListener { parent, view, position, id -> 
            
//            길게 눌렸을 때의 별도 행동.
            val longClickedStudent = mStudentList[position]

//            Toast.makeText(this, "${longClickedStudent.name} 길게 클릭됨", Toast.LENGTH_SHORT).show()


//            학생 제거 전에, 진짜로 삭제할건지 물어보자. AlerDialog
            val alert = AlertDialog.Builder(  this)
//            alert.setTitle("학생 삭제 확인")
            alert.setMessage("정말 ${longClickedStudent.name} 학생을 삭제하시겠습니가?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

//             확인 버튼이 눌릴때 실행할 코드

//            찾아낸 학생을 목록에서 제거. -> 리스트뷰 내용물 변경

                mStudentList.remove(longClickedStudent)


//            어댑터 새로고침
                mStudentAdapter.notifyDataSetChanged()

            })
//            alert.setNegativeButton("취소",null)

            alert.show()




            return@setOnItemLongClickListener true
            
        }


    }
}