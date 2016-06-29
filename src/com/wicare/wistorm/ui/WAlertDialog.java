package com.wicare.wistorm.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.wicare.wistorm.R;


/**
 * @author Wu
 * 
 * 自定义加载弹框
 */
public class WAlertDialog extends Dialog{

	public WAlertDialog(Context context, int theme) {
	    super(context, theme);  
	}  
	  
	protected WAlertDialog(Context context, boolean cancelable,
                             OnCancelListener cancelListener) {
	    super(context, cancelable, cancelListener);  
	}  
	  
	public WAlertDialog(Context context) {
	    super(context);  
	} 

	 /**
	 * 所有的方法执行完都会返回一个Builder
	 * 使得后面可以直接create和show 
	 */
	public static class Builder {  
        private Context context;  
        private String title;  
        private String message;  
        private String positiveButtonText;//确定按钮  
        private String negativeButtonText;//取消按钮
        //确定按钮事件  
        private OnClickListener positiveButtonClickListener;
        //取消按钮事件  
        private OnClickListener negativeButtonClickListener;
  
        public Builder(Context context) {  
            this.context = context;  
        } 
        
        /** 
         * 从资源文件中设置 dialog的消息
         * @param message 
         * @return 
         */  
        public Builder setMessage(int message) {  
            this.message = (String) context.getText(message);  
            return this;  
        }  

        /**
         * 用字符串设置 dialog的消息 
         * @param message
         * @return
         */
        public Builder setMessage(String message) {  
            this.message = message;  
            return this;  
        }

        /** 
         * 从资源文件中设置 dialog的标题
         * @param title 
         * @return 
         */  
        public Builder setTitle(int title) {  
            this.title = (String) context.getText(title);  
            return this;  
        }

        /** 
         * 用字符串设置 dialog的标题 
         * @param title 
         * @return 
         */  
        public Builder setTitle(String title) {  
            this.title = title;  
            return this;  
        }  

        /** 
         * 设置确定按钮和其点击事件   
         * @param positiveButtonText 
         * @return 
         */    
        public Builder setPositiveButton(String positiveButtonText,  
                OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;  
            this.positiveButtonClickListener = listener;  
            return this;  
        }  
        
        /** 
        * 设置取消按钮和其点击事件
        * @return
         * @param negativeButtonText
         * @param listener
        */
        public Builder setNegativeButton(String negativeButtonText,  
                OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;  
            this.negativeButtonClickListener = listener;  
            return this;  
        }  

        /**
         * 对话框的 createview方法 
         * @return
         */
        @SuppressLint("InflateParams") 
        public WAlertDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 设置其风格  
            final WAlertDialog dialog = new WAlertDialog(context,R.style.progressDialog);
            View layout = inflater.inflate(R.layout.ws_customs_dialog, null);
            dialog.addContentView(layout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            if(title != null){
                // 设置标题
                ((TextView) layout.findViewById(R.id.tv_title)).setText(title);
            }else{
                layout.findViewById(R.id.tv_title).setVisibility(View.GONE);
            }
            if (positiveButtonText != null) {  
                ((TextView) layout.findViewById(R.id.btn_pos)).setText(positiveButtonText);
                if (positiveButtonClickListener != null) {  
                    ((TextView) layout.findViewById(R.id.btn_pos)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveButtonClickListener.onClick(dialog,
                                    DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }  
            } else {
                layout.findViewById(R.id.btn_pos).setVisibility(View.GONE);
            }
            if (negativeButtonText != null) {  
                ((TextView) layout.findViewById(R.id.btn_neg)).setText(negativeButtonText);
                if (negativeButtonClickListener != null) {  
                    ((TextView) layout.findViewById(R.id.btn_neg)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(dialog,DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }  
            } else {
                layout.findViewById(R.id.btn_neg).setVisibility(View.GONE);
            }
            if (message != null) {  
                ((TextView) layout.findViewById(R.id.tv_msg)).setText(message);
            }else{
                layout.findViewById(R.id.tv_msg).setVisibility(View.GONE);
            }
            dialog.setContentView(layout);  
            return dialog;  
        }
    }  
}
