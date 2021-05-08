package com.suntelecoms.mescourses.core

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.suntelecoms.mescourses.AppClass
import com.suntelecoms.mescourses.R
import com.suntelecoms.mescourses.helpers.IOnBackPressed
import com.suntelecoms.mescourses.shared.dialogs.ProgressDialogFragment

/**
 * @Author Moustapha S. Dieme ( Djvmil_ ) on 8/15/20
 */
open class BaseActivity : AppCompatActivity(), IOnBackPressed {

    private lateinit var progressDialog: ProgressDialogFragment
    private lateinit var sweetAlertDialog: SweetAlertDialog

    lateinit var app: AppClass


    companion object{
        const val ALERT_TYPE_SUCCESS = 22
        const val ALERT_TYPE_WARNING = 23
        const val ALERT_TYPE_NORMAL  = 24
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = application as AppClass
        sweetAlertDialog = SweetAlertDialog(this)
        createProgressDialog()
    }

    private fun createProgressDialog() {
        progressDialog = ProgressDialogFragment.createDialog()
    }




    fun showProgressDialog() {
//        supportFragmentManager.executePendingTransactions()
        if (!progressDialog.isAdded) {
            progressDialog.show(this, "ProgressDialog")
        }
    }

    fun hideProgressDialog() {
        Log.e("BaseActivity", "hideProgressDialog: " )
        if (progressDialog.isAdded) {
            progressDialog.dismiss()
        }
    }


    fun showSweetAlert(title: String, message: String, alertType: Int, cancelable: Boolean): SweetAlertDialog {
        sweetAlertDialog.changeAlertType(alertType)
        sweetAlertDialog.setCancelable(cancelable)
        title.let { sweetAlertDialog.setTitleText(title) }
        message.let { sweetAlertDialog.setContentText(message) }
        sweetAlertDialog.show()
        return sweetAlertDialog
    }

    fun dismissSweetAlert() {
        if (sweetAlertDialog.isShowing)
            sweetAlertDialog.dismissWithAnimation()
    }


    fun showAlertDialog(
        title:String?, msg: String?,
        alertType: Int, cancelable: Boolean,
        goneCancelButton: Boolean = true,
        validFunction: () -> Unit ={},
        cancelFunction: () -> Unit = {},
        viewDialogId: Int = R.layout.view_alert_dialog,
        initFunction: (view: View) -> Unit = {}): Dialog {


        val dialogTransparent = Dialog(this, R.style.DialogCustomTheme)
        try{

            runOnUiThread{
                val view: View = LayoutInflater.from(this).inflate(viewDialogId, null)
                val viewCancel: LinearLayout = view.findViewById(R.id.ll_cancel)
                val viewValide: LinearLayout = view.findViewById(R.id.ll_valid)
                val title_dialog: TextView = view.findViewById(R.id.title_dialog)
                val message_dialog: TextView = view.findViewById(R.id.message_dialog)
                val icon_resultat: ImageView = view.findViewById(R.id.icon_resultat)

                when(alertType){
                    ALERT_TYPE_NORMAL -> {
                            icon_resultat.visibility = View.GONE
                            viewCancel.visibility = View.GONE
                        }
                    ALERT_TYPE_WARNING -> icon_resultat.setImageResource(R.drawable.ic_error_outline)
                    ALERT_TYPE_SUCCESS -> icon_resultat.setImageResource(R.drawable.ic_check_circle_green)
                }


                title_dialog.text = title ?: title_dialog.text
                message_dialog.text = msg ?: message_dialog.text

                viewCancel.visibility = if (goneCancelButton) View.GONE else View.VISIBLE
                viewValide.setOnClickListener {
                    validFunction()
                    dialogTransparent.dismiss()
                }

                initFunction(view)

                viewCancel.setOnClickListener {
                    cancelFunction()
                    dialogTransparent.dismiss()
                }

                dialogTransparent.setCancelable(cancelable)
                dialogTransparent.setContentView(view)
                dialogTransparent.show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
           // finish()
        }

        return dialogTransparent
    }


    override fun onBackPress(): Boolean {
        return false
    }


}