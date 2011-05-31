package jp.gr.java_conf.tslove.tsemojipicker;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TsEmojiPicker extends Activity {
	private static final String ACTION_INTERCEPT = "com.adamrocker.android.simeji.ACTION_INTERCEPT";
	private static final String REPLACE_KEY = "replace_key";
	private String mReplaceString;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent it = getIntent();
		String action = it.getAction();

		if (action != null && ACTION_INTERCEPT.equals(action)) {
			/* SimejiÇ©ÇÁåƒèoÇ≥ÇÍÇΩéû */
			mReplaceString = it.getStringExtra(REPLACE_KEY);// íuä∑å≥ÇÃï∂éöÇéÊìæ
		}
		setContentView(R.layout.main);
		((Button) findViewById(R.id.buttonOk)).setOnClickListener(mOkListener);
		((Button) findViewById(R.id.buttonCancel)).setOnClickListener(mCancelListener);
		((Button) findViewById(R.id.buttonBS)).setOnClickListener(mBSListener);
        GridView gridview = (GridView) findViewById(R.id.gridViewEmoji);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(mItenClickListener);
    }

    private ArrayList<String> mEmojiString = new ArrayList<String>();
	private ArrayList<ImageView> mEmojiView = new ArrayList<ImageView>();
	
	OnClickListener mOkListener = new OnClickListener() {
		public void onClick(View v) {
			StringBuffer result = new StringBuffer();
			Integer i;
			for (i = 0; i < mEmojiString.size(); i++) {
				result.append(mEmojiString.get(i));
			}
			
			Intent data = new Intent();
	        Intent it = getIntent();
			String action = it.getAction();
			if (action != null && ACTION_INTERCEPT.equals(action)) {
				data.putExtra(REPLACE_KEY, result.toString());
				setResult(RESULT_OK, data);

			} else {
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				cm.setText(result.toString());
			}

			finish();
		}
	};

	OnClickListener mCancelListener = new OnClickListener() {
		public void onClick(View v) {
			finish();
		}
	};

	OnClickListener mBSListener = new OnClickListener() {
		public void onClick(View v) {
			if (mEmojiString.size() > 0) {
				LinearLayout chooseEmoji = (LinearLayout) findViewById(R.id.linearLayoutChooseEmoji);
				ImageView imageView = mEmojiView.get(mEmojiView.size() - 1);

				chooseEmoji.removeView(imageView);
				mEmojiView.remove(mEmojiView.size() - 1);

				mEmojiString.remove(mEmojiString.size() - 1);
			}
		}
	};

    OnItemClickListener mItenClickListener = new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			if (mEmojiString.size() < 20) {
				ImageView imageView = new ImageView(v.getContext());
				imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setBackgroundColor(Color.WHITE);

				LinearLayout chooseEmoji = (LinearLayout) findViewById(R.id.linearLayoutChooseEmoji);

				mEmojiString.add("[i:" + (position + 1) + "]");

				mEmojiView.add(imageView);
				imageView.setImageResource(mThumbIds[position]);
				chooseEmoji.addView(imageView);
			} else {
				Toast.makeText(TsEmojiPicker.this, R.string.msg_limit, Toast.LENGTH_SHORT).show();
			}
		}
    };

    private Integer[] mThumbIds = {
    		R.drawable.i1,
    		R.drawable.i2,
    		R.drawable.i3,
    		R.drawable.i4,
    		R.drawable.i5,
    		R.drawable.i6,
    		R.drawable.i7,
    		R.drawable.i8,
    		R.drawable.i9,
    		R.drawable.i10,
    		R.drawable.i11,
    		R.drawable.i12,
    		R.drawable.i13,
    		R.drawable.i14,
    		R.drawable.i15,
    		R.drawable.i16,
    		R.drawable.i17,
    		R.drawable.i18,
    		R.drawable.i19,
    		R.drawable.i20,
    		R.drawable.i21,
    		R.drawable.i22,
    		R.drawable.i23,
    		R.drawable.i24,
    		R.drawable.i25,
    		R.drawable.i26,
    		R.drawable.i27,
    		R.drawable.i28,
    		R.drawable.i29,
    		R.drawable.i30,
    		R.drawable.i31,
    		R.drawable.i32,
    		R.drawable.i33,
    		R.drawable.i34,
    		R.drawable.i35,
    		R.drawable.i36,
    		R.drawable.i37,
    		R.drawable.i38,
    		R.drawable.i39,
    		R.drawable.i40,
    		R.drawable.i41,
    		R.drawable.i42,
    		R.drawable.i43,
    		R.drawable.i44,
    		R.drawable.i45,
    		R.drawable.i46,
    		R.drawable.i47,
    		R.drawable.i48,
    		R.drawable.i49,
    		R.drawable.i50,
    		R.drawable.i51,
    		R.drawable.i52,
    		R.drawable.i53,
    		R.drawable.i54,
    		R.drawable.i55,
    		R.drawable.i56,
    		R.drawable.i57,
    		R.drawable.i58,
    		R.drawable.i59,
    		R.drawable.i60,
    		R.drawable.i61,
    		R.drawable.i62,
    		R.drawable.i63,
    		R.drawable.i64,
    		R.drawable.i65,
    		R.drawable.i66,
    		R.drawable.i67,
    		R.drawable.i68,
    		R.drawable.i69,
    		R.drawable.i70,
    		R.drawable.i71,
    		R.drawable.i72,
    		R.drawable.i73,
    		R.drawable.i74,
    		R.drawable.i75,
    		R.drawable.i76,
    		R.drawable.i77,
    		R.drawable.i78,
    		R.drawable.i79,
    		R.drawable.i80,
    		R.drawable.i81,
    		R.drawable.i82,
    		R.drawable.i83,
    		R.drawable.i84,
    		R.drawable.i85,
    		R.drawable.i86,
    		R.drawable.i87,
    		R.drawable.i88,
    		R.drawable.i89,
    		R.drawable.i90,
    		R.drawable.i91,
    		R.drawable.i92,
    		R.drawable.i93,
    		R.drawable.i94,
    		R.drawable.i95,
    		R.drawable.i96,
    		R.drawable.i97,
    		R.drawable.i98,
    		R.drawable.i99,
    		R.drawable.i100,
    		R.drawable.i101,
    		R.drawable.i102,
    		R.drawable.i103,
    		R.drawable.i104,
    		R.drawable.i105,
    		R.drawable.i106,
    		R.drawable.i107,
    		R.drawable.i108,
    		R.drawable.i109,
    		R.drawable.i110,
    		R.drawable.i111,
    		R.drawable.i112,
    		R.drawable.i113,
    		R.drawable.i114,
    		R.drawable.i115,
    		R.drawable.i116,
    		R.drawable.i117,
    		R.drawable.i118,
    		R.drawable.i119,
    		R.drawable.i120,
    		R.drawable.i121,
    		R.drawable.i122,
    		R.drawable.i123,
    		R.drawable.i124,
    		R.drawable.i125,
    		R.drawable.i126,
    		R.drawable.i127,
    		R.drawable.i128,
    		R.drawable.i129,
    		R.drawable.i130,
    		R.drawable.i131,
    		R.drawable.i132,
    		R.drawable.i133,
    		R.drawable.i134,
    		R.drawable.i135,
    		R.drawable.i136,
    		R.drawable.i137,
    		R.drawable.i138,
    		R.drawable.i139,
    		R.drawable.i140,
    		R.drawable.i141,
    		R.drawable.i142,
    		R.drawable.i143,
    		R.drawable.i144,
    		R.drawable.i145,
    		R.drawable.i146,
    		R.drawable.i147,
    		R.drawable.i148,
    		R.drawable.i149,
    		R.drawable.i150,
    		R.drawable.i151,
    		R.drawable.i152,
    		R.drawable.i153,
    		R.drawable.i154,
    		R.drawable.i155,
    		R.drawable.i156,
    		R.drawable.i157,
    		R.drawable.i158,
    		R.drawable.i159,
    		R.drawable.i160,
    		R.drawable.i161,
    		R.drawable.i162,
    		R.drawable.i163,
    		R.drawable.i164,
    		R.drawable.i165,
    		R.drawable.i166,
    		R.drawable.i167,
    		R.drawable.i168,
    		R.drawable.i169,
    		R.drawable.i170,
    		R.drawable.i171,
    		R.drawable.i172,
    		R.drawable.i173,
    		R.drawable.i174,
    		R.drawable.i175,
    		R.drawable.i176,
    		R.drawable.i177,
    		R.drawable.i178,
    		R.drawable.i179,
    		R.drawable.i180,
    		R.drawable.i181,
    		R.drawable.i182,
    		R.drawable.i183,
    		R.drawable.i184,
    		R.drawable.i185,
    		R.drawable.i186,
    		R.drawable.i187,
    		R.drawable.i188,
    		R.drawable.i189,
    		R.drawable.i190,
    		R.drawable.i191,
    		R.drawable.i192,
    		R.drawable.i193,
    		R.drawable.i194,
    		R.drawable.i195,
    		R.drawable.i196,
    		R.drawable.i197,
    		R.drawable.i198,
    		R.drawable.i199,
    		R.drawable.i200,
    		R.drawable.i201,
    		R.drawable.i202,
    		R.drawable.i203,
    		R.drawable.i204,
    		R.drawable.i205,
    		R.drawable.i206,
    		R.drawable.i207,
    		R.drawable.i208,
    		R.drawable.i209,
    		R.drawable.i210,
    		R.drawable.i211,
    		R.drawable.i212,
    		R.drawable.i213,
    		R.drawable.i214,
    		R.drawable.i215,
    		R.drawable.i216,
    		R.drawable.i217,
    		R.drawable.i218,
    		R.drawable.i219,
    		R.drawable.i220,
    		R.drawable.i221,
    		R.drawable.i222,
    		R.drawable.i223,
    		R.drawable.i224,
    		R.drawable.i225,
    		R.drawable.i226,
    		R.drawable.i227,
    		R.drawable.i228,
    		R.drawable.i229,
    		R.drawable.i230,
    		R.drawable.i231,
    		R.drawable.i232,
    		R.drawable.i233,
    		R.drawable.i234,
    		R.drawable.i235,
    		R.drawable.i236,
    		R.drawable.i237,
    		R.drawable.i238,
    		R.drawable.i239,
    		R.drawable.i240,
    		R.drawable.i241,
    		R.drawable.i242,
    		R.drawable.i243,
    		R.drawable.i244,
    		R.drawable.i245,
    		R.drawable.i246,
    		R.drawable.i247,
    		R.drawable.i248,
    		R.drawable.i249,
    		R.drawable.i250,
    		R.drawable.i251,
    		R.drawable.i252
    		};
}