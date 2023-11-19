package com.ksivol_project.necoguide2021

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ksivol_project.necoguide2021.constance.Constance
import com.ksivol_project.necoguide2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "empty"
    private var passwod: String = "empty"
    private var name: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            if (login == l && passwod == p) {

                bindingClass.imAvater.visibility = View.VISIBLE
                bindingClass.imAvater.setImageResource(avatarImageId)
                val textInfo = "$name $name2 $name3"
                bindingClass.tvInfo.text = textInfo
                bindingClass.bHide.visibility = View.GONE
                bindingClass.bExit.text = "Выйти"

            } else {
                bindingClass.imAvater.visibility = View.VISIBLE
                bindingClass.imAvater.setImageResource(R.drawable.ic)
                bindingClass.tvInfo.text = "Такого аккаунта не существует!"

            }

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {

            login = data?.getStringExtra(Constance.LOGIN)!!
            passwod = data.getStringExtra(Constance.PASSWORD)!!
            name = data.getStringExtra(Constance.NAME)!!
            name2 = data.getStringExtra(Constance.NAME2)!!
            name3 = data.getStringExtra(Constance.NAME3)!!
            avatarImageId = data.getIntExtra(Constance.AVATAR_ID, 0)
            bindingClass.imAvater.visibility = View.VISIBLE
            bindingClass.imAvater.setImageResource(avatarImageId)
            val textInfo = "$name $name2 $name3"
            bindingClass.tvInfo.text = textInfo
            bindingClass.bHide.visibility = View.GONE
            bindingClass.bExit.text = "Выйти"
        }
    }

    fun onClickSingIn(view: View) {

        if (bindingClass.imAvater.isVisible && bindingClass.tvInfo.text.toString() != "Такого аккаунта не существует!") {

            bindingClass.imAvater.visibility = View.INVISIBLE
            bindingClass.tvInfo.text = ""
            bindingClass.bHide.visibility = View.VISIBLE
            bindingClass.bExit.text = getString(R.string.sign_in)

        } else {

            val intent = Intent(this, SingInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }

    }


    fun onClickSingUp(view: View) {

        val intent = Intent(this, SingInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)

    }

}