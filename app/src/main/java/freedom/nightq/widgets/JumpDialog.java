package freedom.nightq.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 */
public class JumpDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private int mDialogRowCount = 1;
    private JumpDialogItemClickListener mListener;
    private int[] titleStrs;
    private int[] iconRes;// 可以设置图标

    private LinearLayout[] itemLLs = new LinearLayout[6];
    private ImageView[] itemIVs = new ImageView[6];
    private TextView[] itemTVs = new TextView[6];
    private View[] itemLines = new View[5];
    private Object[] tagObject;// 可以自定义传任何参数, 也可以不用

    public interface JumpDialogItemClickListener {
        public void clickJumpDialogItem(int rowId, Object... tagObject);
    }

    public void setTagObject(Object... tagObject) {
        this.tagObject = tagObject;
    }

    public JumpDialog(Context context, int[] rowStrArr, JumpDialogItemClickListener listener) {
        this(context, null, rowStrArr, listener);
    }

    public JumpDialog(Context context, int[] iconResArr, int[] rowStrArr, JumpDialogItemClickListener listener) {
        super(context, R.style.theme_dialog_transparent2);
        mContext = context;
        mDialogRowCount = rowStrArr.length;
        iconRes = iconResArr;
        titleStrs = rowStrArr;
        setItemCliclkListener(listener);
    }

    public void setItemCliclkListener(JumpDialogItemClickListener listener) {
        mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jump_dialog);
        setCanceledOnTouchOutside(true);
        initView();
        initData();
    }

    private void initView() {
        itemLLs[0] = (LinearLayout) findViewById(R.id.jumpDialog_1);
        itemLLs[1] = (LinearLayout) findViewById(R.id.jumpDialog_2);
        itemLLs[2] = (LinearLayout) findViewById(R.id.jumpDialog_3);
        itemLLs[3] = (LinearLayout) findViewById(R.id.jumpDialog_4);
        itemLLs[4] = (LinearLayout) findViewById(R.id.jumpDialog_5);
        itemLLs[5] = (LinearLayout) findViewById(R.id.jumpDialog_6);

        itemIVs[0] = (ImageView) findViewById(R.id.jumpDialog_iv1);
        itemIVs[1] = (ImageView) findViewById(R.id.jumpDialog_iv2);
        itemIVs[2] = (ImageView) findViewById(R.id.jumpDialog_iv3);
        itemIVs[3] = (ImageView) findViewById(R.id.jumpDialog_iv4);
        itemIVs[4] = (ImageView) findViewById(R.id.jumpDialog_iv5);
        itemIVs[5] = (ImageView) findViewById(R.id.jumpDialog_iv6);

        itemTVs[0] = (TextView) findViewById(R.id.jumpDialog_tv1);
        itemTVs[1] = (TextView) findViewById(R.id.jumpDialog_tv2);
        itemTVs[2] = (TextView) findViewById(R.id.jumpDialog_tv3);
        itemTVs[3] = (TextView) findViewById(R.id.jumpDialog_tv4);
        itemTVs[4] = (TextView) findViewById(R.id.jumpDialog_tv5);
        itemTVs[5] = (TextView) findViewById(R.id.jumpDialog_tv6);

        itemLines[0] = findViewById(R.id.jumpDialog_line1);
        itemLines[1] = findViewById(R.id.jumpDialog_line2);
        itemLines[2] = findViewById(R.id.jumpDialog_line3);
        itemLines[3] = findViewById(R.id.jumpDialog_line4);
        itemLines[4] = findViewById(R.id.jumpDialog_line5);
        for (LinearLayout ll : itemLLs) {
            ll.setOnClickListener(this);
        }
    }

    private void initData() {
        for (int n = 0; n < titleStrs.length; n++) {
            itemTVs[n].setText(titleStrs[n]);
        }

        if (iconRes != null) {
            for (int n = 0; n < iconRes.length; n++) {
                itemIVs[n].setImageResource(iconRes[n]);
                itemIVs[n].setVisibility(View.VISIBLE);
            }
        }

        if (mDialogRowCount > 5) {
            itemLines[4].setVisibility(View.VISIBLE);
            itemLLs[5].setVisibility(View.VISIBLE);
        }

        if (mDialogRowCount > 4) {
            itemLines[3].setVisibility(View.VISIBLE);
            itemLLs[4].setVisibility(View.VISIBLE);
        }

        if (mDialogRowCount > 3) {
            itemLines[2].setVisibility(View.VISIBLE);
            itemLLs[3].setVisibility(View.VISIBLE);
        }

        if (mDialogRowCount > 2) {
            itemLines[1].setVisibility(View.VISIBLE);
            itemLLs[2].setVisibility(View.VISIBLE);
        }

        if (mDialogRowCount > 1) {
            itemLines[0].setVisibility(View.VISIBLE);
            itemLLs[1].setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        if (mListener == null) {
            return;
        }

        switch (view.getId()) {
            case R.id.jumpDialog_1:
                mListener.clickJumpDialogItem(titleStrs[0], tagObject);
                break;
            case R.id.jumpDialog_2:
                mListener.clickJumpDialogItem(titleStrs[1], tagObject);
                break;
            case R.id.jumpDialog_3:
                mListener.clickJumpDialogItem(titleStrs[2], tagObject);
                break;
            case R.id.jumpDialog_4:
                mListener.clickJumpDialogItem(titleStrs[3], tagObject);
                break;
            case R.id.jumpDialog_5:
                mListener.clickJumpDialogItem(titleStrs[4], tagObject);
                break;
            case R.id.jumpDialog_6:
                mListener.clickJumpDialogItem(titleStrs[5], tagObject);
                break;
        }
    }
}
