package com.foo.lab13;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);

        EditTextPreference idPreference = findPreference("id");
        ListPreference colorPreference = findPreference("color");

        colorPreference.setSummaryProvider(ListPreference.SimpleSummaryProvider.getInstance());

        idPreference.setSummaryProvider(new Preference.SummaryProvider() {
            @Nullable
            @Override
            public CharSequence provideSummary(@NonNull Preference preference) {
                String text = idPreference.getText();
                if (TextUtils.isEmpty(text)) return "설정이 되지 않았습니다.";

                return "설정된 ID 값은 " + text + " 입니다.";
            }
        });

        idPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                String key = preference.getKey();
                String value = (String) newValue;
                Log.d("kkang", key + " is changed into " + value);
                return true;
            }
        });
    }
}