package com.ksivol_project.necoguide2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.ksivol_project.necoguide2021.constance.Constance
import com.ksivol_project.necoguide2021.databinding.ActivitySignUpInBinding

class SingInUpAct : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignUpInBinding
    private var signState = "empty"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignUpInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (signState == Constance.SIGN_IN_STATE) {
            bindingClass.edName.visibility = View.GONE
            bindingClass.edName2.visibility = View.GONE
            bindingClass.edName3.visibility = View.GONE
            bindingClass.edName.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE
        }


    }

    fun onClickDone(view: View) {
        if (signState == Constance.SIGN_UP_STATE) {
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName.toString())
            intent.putExtra(Constance.NAME2, bindingClass.edName2.toString())
            intent.putExtra(Constance.NAME3, bindingClass.edName3.toString())
            if (bindingClass.imAvatar.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.ic)
            setResult(RESULT_OK, intent)
            finish()
        } else if(signState == Constance.SIGN_IN_STATE){
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatar(view: View) {

        bindingClass.imAvatar.visibility = View.VISIBLE

    }

}