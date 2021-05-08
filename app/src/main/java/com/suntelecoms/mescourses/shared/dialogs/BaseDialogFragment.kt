package com.suntelecoms.mescourses.shared.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suntelecoms.mescourses.R
import com.suntelecoms.mescourses.core.BaseActivity
import kotlinx.android.synthetic.main.view_dialog_default.*

/**
 * @Author Moustapha S. Dieme ( Djvmil_ ) on 5/18/20
 */
class BaseDialogFragment : androidx.fragment.app.DialogFragment() {

    private lateinit var listener: DialogFragmentListener
    lateinit var mContext: Context
    lateinit var dialogMessage: String
    lateinit var dialogTitle: String
    var textOkButton: String? = null

    companion object {

        @JvmStatic
        fun createDialog(): BaseDialogFragment {
            val frag = BaseDialogFragment()
            return frag
        }
    }

    fun setListener(listener: DialogFragmentListener) {
        this.listener = listener
    }

    fun show(activity: BaseActivity, tag: String) {
        super.show(activity.supportFragmentManager, tag)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.BaseDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.view_dialog_default, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_message_dialog.text = dialogMessage
        tv_title_dialog.text = dialogTitle

        if (textOkButton != null) {
            dialog_confirm.text = textOkButton
        } else {
            dialog_confirm.text = "OK"
        }

        dialog_confirm.setOnClickListener {
            dismiss()
            if (::listener.isInitialized)
                listener.onDoneClicked(this)
        }

    }

}
