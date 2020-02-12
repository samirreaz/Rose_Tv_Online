package com.rosetvonline.rosetvonline.Home.Search.Category;

import com.rosetvonline.rosetvonline.Home.Search.Search_viewFragment;
import com.rosetvonline.rosetvonline.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {
    private String itemName;
    private String itemDescription;
    private String itemCategoryName;
    private int itemImage;
    private String itemTages;

    public Item() {
    }

    public Item(String itemName, String itemDescription, String itemCategoryName, int itemImage, String itemTages) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategoryName = itemCategoryName;
        this.itemImage = itemImage;
        this.itemTages = itemTages;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemTages() {
        return itemTages;
    }

    public void setItemTages(String itemTages) {
        this.itemTages = itemTages;
    }

    public static ArrayList<Item> genetateCategory(){
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("কোরআন তেলাওয়াত","Milad","Quran Tilawat", R.drawable.quran,"Milad"));
        items.add(new Item("দরবারশরীফের ডকুমেন্টরি","Milad","BZM Documentory", R.drawable.documentory,"Milad"));
        items.add(new Item("ছানি ফয়েজ","Gojol","Chani Foyaj", R.drawable.sani,"Gojol"));
        items.add(new Item("দোয়া মোনাজাত","mawlana","Doya Monajat", R.drawable.monajat,"waj"));
        items.add(new Item("গজল","mawlana","Gojol", R.drawable.gojol,"waj"));
        items.add(new Item("খাজাবাবার বাণী","Rohmot","Khajababar Bani", R.drawable.khaza_baba_r_nosihot,"Rohmot"));
        items.add(new Item("খাজাবাবার নসিহত ","waj","Khajababar Nosihoth", R.drawable.nosihot,"waj"));
        items.add(new Item("খাজাবাবার রহমতের ফয়েজ","mawlana","Khajababar Rohomoter Foyaj", R.drawable.khajababar_rohomotar_foaz,"waj"));
        items.add(new Item("খাজাবাবার জিকির","mawlana","Khajababar Zikir", R.drawable.visual,"Milad"));
        items.add(new Item("সরাসরি সম্প্রচার","mawlana","Live", R.drawable.live,"Gojol"));
        items.add(new Item("মিলাদ কেয়াম","mawlana","Milad Kiyam", R.drawable.milad,"Rohmot"));
        items.add(new Item("রহমতের ফয়েজ","mawlana","Rohomoter Foyaj", R.drawable.rohomot,"waj"));
        items.add(new Item("তরিকতের ফয়েজ","mawlana","Torikoter Foyaj", R.drawable.torikotar_foaz,"waj"));
        items.add(new Item("ওয়াজ মাহফিল","mawlana","Waze Mahfil", R.drawable.waze_mafil,"waj"));
        items.add(new Item("জিকির","mawlana","Zikir", R.drawable.zikir,"waj"));

        /*Mowlana category*/
        items.add(new Item("আলহাজ্ব শাহাব উদ্দিন খান মিয়ামামা","mawlana","Alhaz Sahabuddin Khan Mia Mama", R.drawable.cor,"waj"));
        items.add(new Item("মুফতি আবু নাছের জিহাদী","mawlana","Mufti Abu Nasir Jihadi", R.drawable.mufti_abu_nasar_jahadi,"waj"));
        items.add(new Item("বিশ্বওলী খাজাবাবা ফরিদপুরী","mawlana","Bisso Oli Khaja Baba Faridpuri", R.drawable.khajababa_faridpuri,"waj"));
        items.add(new Item("মাওলানা আছাদুজ্জামান ঝিনাইদহ","mawlana","Mawlana Asaduzzaman Jhenaidah", R.drawable.maulana_asaduzzaman,"waj"));
        items.add(new Item("মুফতি আশরাফ বিল্লাহ আল উসমানী","mawlana","Mufty Asraf Billal Al Usmani",R.drawable.ashraf_billa_al_usmani,"waj"));
        items.add(new Item("মুফতি আব্দুর রাজ্জাক উসমানী","mawlana","Mufti Abdur Razzak Osmani", R.drawable.abdur_razzak_usmani,"waj"));
        items.add(new Item("মুফতি আলাউদ্দিন জিহাদি","mawlana","Mufti Alauddin Jihadi", R.drawable.alauddin_jehadi,"waj"));
        items.add(new Item("মুফতি বিল্লাল হোসেন আনসারী","mawlana","Mufty Billal Hosen Ansari", R.drawable.mowlana_biilal_hossen_ansari,"waj"));
        items.add(new Item("মুফতি জহিরুল ইসলাম ফরীদি","mawlana","Mufti Jahirul Islam Foridi", R.drawable.johurul_islam_foridi,"waj"));
        items.add(new Item("মুফতি কামরুজ্জামান নুরী","mawlana","Mufti Kamruzzaman Nuri", R.drawable.kamruzzaman_nuri,"waj"));
        items.add(new Item("মুফতি লিয়াকত আলী আশেকী","mawlana","Mufti Leakot Ali Aseki", R.drawable.mufti_leakot_ali_aseki1,"waj"));
        items.add(new Item("মুফতি মাসুদুর রহমান হামিদী","mawlana","Mufti Masudur Rahman Hamidi", R.drawable.masudur_rahman,"waj"));
        items.add(new Item("মুফতি রফিকুল ইসলাম মিরাজি","mawlana","Mufti Rofiqul Islam Mirazi", R.drawable.mufti_rafiqul_islam_miraji,"waj"));
        items.add(new Item("মাওলানা মাহবুবুর রহমান মাজহারী","mawlana","Mawlana Mahbubur Rahman Mazhari", R.drawable.mahbubur_mahman_mazhari,"waj"));
        items.add(new Item("মাওলানা হাসান সিরাজী","mawlana","MawlanaMawlana Hasan Siraji", R.drawable.hasan_siraji,"waj"));
        items.add(new Item("মাওলানা সাঈদ আহমেদ","mawlana","Maulana Syed Ahmed", R.drawable.maulana_syed_ahmed,"waj"));
        items.add(new Item("মাওলানা তাজুল ইসলাম চাঁদপুরী","mawlana","Maulana Tajul Islam Chandpuri", R.drawable.tajul_islam_chandpuri,"waj"));
        items.add(new Item("মোশারফ হোসেন হেলালী","mawlana","Mosarof Hossen Helali", R.drawable.monsur_helali,"waj"));
        items.add(new Item("মৌলভী আব্দল্লাহ আল মামুন","mawlana","Mowlovi Abdullah Al Mamun", R.drawable.mowlovi_abdullah_al_mamun,"waj"));
        items.add(new Item("কারী রুহুল আমিন সিদ্দিকী","mawlana","Qari Ruhul Amin Siddiqui", R.drawable.kari_ruhul_amin_iddiqi,"waj"));
        items.add(new Item("মাওলানা ইমরান হুসেইন মাজহারী","mawlana","Mawlana Emran Hussin Majhari", R.drawable.imran_hosen_mazhari,"waj"));



        items.add(new Item("মুফতি আবুল কাশেম জিহাদী","mawlana","Mufti Abul Kashem Jihadi", R.drawable.abul_kasem_jehadi,"waj"));
        items.add(new Item("হাফেজ আবুল ফজল নোমানী","mawlana","Hafez Abul Fazal Nomani", R.drawable.abul_fojol_nomani,"waj"));
        items.add(new Item("মাওলানা জামশেদ কবির বাকীবিল্লাহ","mawlana","Mawlana Jamshed Kabir Baki Billah", R.drawable.kazi_bakki_billah,"waj"));
        items.add(new Item("মাওলানা নূরে আলম","mawlana","Maulana Nure Alom", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা আব্দুল কাদের লোহানী","mawlana","Maulana Abdul Kader Lohani", R.drawable.lohani1,"waj"));
        items.add(new Item("হাফেজ সিরাজুল ইসলাম","mawlana","Hafez Sirajul Islam", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা আক্কাস আলী","mawlana","Maulana Akkas Ali", R.drawable.akkas_ali,"waj"));
        items.add(new Item("মাওলানা আল আমিন জিহাদী","mawlana","Maulana Al Amin Jihadi", R.drawable.al_amin_jihadi,"waj"));
        items.add(new Item("মাওলানা আব্দুল কাইয়ুম","mawlana","Maulana Abdul Kaium", R.drawable.cor,"waj"));
        items.add(new Item("মুফতি ছরোয়ার ফেরদৌস খান","mawlana","Mufti Sorowar Fardous Khan", R.drawable.mufti_sarwar_ferdous_khan,"waj"));
        items.add(new Item("মুফতি আব্দুর লতীফ ফারুকী","mawlana","Mufti Abdur Lotif Faruqi", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা আব্দুস সোবাহান","mawlana","Maulana Abdus Sobhan", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা জাহাঙ্গীর আলম জিহাদী","mawlana","Maulana Jahangir Alam Jihadi", R.drawable.maulana_jahangir_alam_jihadi,"waj"));
        items.add(new Item("মাওলানা ওলী  আহাম্মদ শাহীন","mawlana","Maulana Oli Ahmed Shahin", R.drawable.mowlana_oli_ahamed_shahin,"waj"));
        items.add(new Item("মাওলানা হুমায়ুন কবীর","mawlana","Maulana Humayun Kabir", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা ইসমাইল হোসেন সিরাজী","mawlana","Maulana Ismail Hossain Siraji", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা জসিম উদ্দিন জিহাদী","mawlana","Maulana Josim Uddin Jihadi", R.drawable.cor,"waj"));
        items.add(new Item("মাওলানা আব্দুল কাদির সাদীপুরী","mawlana","Maulana Abdul Kader Sadipuri", R.drawable.sadipuri,"waj"));
        items.add(new Item("মুফতী আব্দুল ওয়াদুদ ছিদ্দিকী","mawlana","Mufti Abdul Wadud Siddiqui", R.drawable.mufti_wadud_siddiqi,"waj"));
        items.add(new Item("মাওলানা রবিউল ইসলাম জিহাদী","mawlana","Maulana Robiul Islam Jihadi", R.drawable.maulana_robiul_islam_zihadi,"waj"));
        items.add(new Item("মাওলানা ওমর ফারুক মুজাহিদী","mawlana","Maulana Omar Faruk Mujahide", R.drawable.mawlaan_omor_faruq_mujahedi,"waj"));
        items.add(new Item("মৌলভী মুন্সী আনোয়ার উদ্দিন","mawlana","Mowlovi Munshi Anwar Uddin", R.drawable.cor,"waj"));
        items.add(new Item("মৌলভী আব্দুল হান্নান","mawlana","Mowlovi Abdul Hannan", R.drawable.abdul_hannan,"waj"));


        items.add(new Item("শাহজাদা খাজা নোমান শাহ","mawlana","Shahjada Khaza Noman Shah", R.drawable.shahjada_shaza_noman_shah,"waj"));
        items.add(new Item("ড.কাফিল উদ্দিন সরকার সালেহী","mawlana","Dr.Kafiluddin Sarkar Salehi", R.drawable.kafil_uddin_sarkar,"waj"));
        items.add(new Item("ড.হুজ্জাতুল্লাহ নকশেবন্দী","mawlana","Dr.Hujjatullah Noksebondi", R.drawable.hozzotula,"waj"));
        items.add(new Item("মুফতি ওসমান গণি সালেহী","mawlana","Mufti Usman Goni Salehi", R.drawable.osman_goni_salehi,"waj"));
        items.add(new Item("মাওলানা শহিদুল্লাহ বাহাদুর","mawlana","Maulana Shahidullah Bahadur", R.drawable.sohidullah_bahadur,"waj"));
        return items;
    }
}
