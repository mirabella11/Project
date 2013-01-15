package com.abc.kids;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

public class GlobalData {

	private static GlobalData mInstance=null;
	public long iduser=0;
	public int [] max_number = new int []{68,22,22};
	public  int[][] img = new int [][] {
			 { R.drawable.anm_1,R.drawable.anm_2,R.drawable.anm_3,R.drawable.anm_4,R.drawable.anm_5,R.drawable.anm_6,
			   R.drawable.anm_7,R.drawable.anm_8,R.drawable.anm_9,R.drawable.anm_10,R.drawable.anm_11,R.drawable.anm_12,
			   R.drawable.anm_13,R.drawable.anm_14,R.drawable.anm_15,R.drawable.anm_16,R.drawable.anm_17,R.drawable.anm_18,
			   R.drawable.anm_19,R.drawable.anm_20,R.drawable.anm_21,R.drawable.anm_22,R.drawable.anm_23,R.drawable.anm_24,
			   R.drawable.anm_25,R.drawable.anm_26,R.drawable.anm_27,R.drawable.anm_28,R.drawable.anm_29,R.drawable.anm_30,
			   R.drawable.anm_31,R.drawable.anm_32,R.drawable.anm_33,R.drawable.anm_34,R.drawable.anm_35,R.drawable.anm_36,
			   R.drawable.anm_37,R.drawable.anm_38,R.drawable.anm_39,R.drawable.anm_40,R.drawable.anm_41,R.drawable.anm_42,
			   R.drawable.anm_43,R.drawable.anm_44,R.drawable.anm_45,R.drawable.anm_46,R.drawable.anm_47,R.drawable.anm_48,
			   R.drawable.anm_49,R.drawable.anm_50,R.drawable.anm_51,R.drawable.anm_52,R.drawable.anm_53,R.drawable.anm_54,
			   R.drawable.anm_55,R.drawable.anm_56,R.drawable.anm_57,R.drawable.anm_58,R.drawable.anm_59,R.drawable.anm_60,
			   R.drawable.anm_61,R.drawable.anm_62,R.drawable.anm_63,R.drawable.anm_64,R.drawable.anm_65,R.drawable.anm_66,
			   R.drawable.anm_67,R.drawable.anm_68 },
			 {  R.drawable.flo_1,R.drawable.flo_2,R.drawable.flo_3,R.drawable.flo_4,R.drawable.flo_5,R.drawable.flo_6,
			   R.drawable.flo_7,R.drawable.flo_8,R.drawable.flo_9,R.drawable.flo_10,R.drawable.flo_11,R.drawable.flo_12,
			   R.drawable.flo_13,R.drawable.flo_14,R.drawable.flo_15,R.drawable.flo_16,R.drawable.flo_17,R.drawable.flo_18,
			   R.drawable.flo_19,R.drawable.flo_20,R.drawable.flo_21,R.drawable.flo_22 },
			 {  R.drawable.fru_1,R.drawable.fru_2,R.drawable.fru_3,R.drawable.fru_4,R.drawable.fru_5,R.drawable.fru_6,
			   R.drawable.fru_7,R.drawable.fru_8,R.drawable.fru_9,R.drawable.fru_10,R.drawable.fru_11,R.drawable.fru_12,
		       R.drawable.fru_13,R.drawable.fru_14,R.drawable.fru_15,R.drawable.fru_16,R.drawable.fru_17,R.drawable.fru_18,
		       R.drawable.fru_19,R.drawable.fru_20,R.drawable.fru_21,R.drawable.fru_22 }}; 
	 
	public int [] voice = new int [] {R.raw.sound_albatross,R.raw.sound_antelop,R.raw.sound_badger,R.raw.sound_bat,R.raw.sound_bear,R.raw.sound_bee,
									  R.raw.sound_bison,R.raw.sound_buffalo,R.raw.sound_camel,R.raw.sound_canary,R.raw.sound_cardinal,R.raw.sound_cat,
									  R.raw.sound_chicken,R.raw.sound_chimpanze,R.raw.sound_cow,R.raw.sound_coyote,R.raw.sound_crocodile,R.raw.sound_raven,
									  R.raw.sound_dog,R.raw.sound_dolphin,R.raw.sound_donkey,R.raw.sound_duck,R.raw.sound_eagle,R.raw.sound_elephant,
									  R.raw.sound_finch,R.raw.sound_flamingo,R.raw.sound_frog,R.raw.sound_gibbon,R.raw.sound_goat,R.raw.sound_goose,
									  R.raw.sound_gorilla,R.raw.sound_hedgehog,R.raw.sound_hippo,R.raw.sound_hog,R.raw.sound_horse,R.raw.sound_hyena,
									  R.raw.sound_jaguar,R.raw.sound_lamb,R.raw.sound_leopard,R.raw.sound_lion,R.raw.sound_llama,R.raw.sound_lynx,
									  R.raw.sound_mockingbird,R.raw.sound_monkey,R.raw.sound_moose,R.raw.sound_mosquito,R.raw.sound_orca,
									  R.raw.sound_owl,R.raw.sound_panther,R.raw.sound_parrot,R.raw.sound_peacock,R.raw.sound_penguin,
									  R.raw.sound_pig,R.raw.sound_dove,R.raw.sound_puma,R.raw.sound_rhino,R.raw.sound_seagull,
									  R.raw.sound_sealion,R.raw.sound_snake,R.raw.sound_sparrow,R.raw.sound_swallow,R.raw.sound_tiger,R.raw.sound_turkey,
									  R.raw.sound_vulture,R.raw.sound_whale,R.raw.sound_wolf,R.raw.sound_woodpecker,R.raw.sound_zebra};
	 
	
	
	public int position = 0;
	public int lng;
	public float msc=1;
	
	public Report lastReport=null;
	protected GlobalData(){
		 
	}
	public static synchronized GlobalData getInstance(){
		if(null==mInstance){
			mInstance = new GlobalData();			
		}
		return mInstance;
	}
	public void setIduser(long a){		
		this.iduser=a;
	}
	public void setPosition(int a){		
		this.position=a;
	}
	public void setReport(Report a){		
		this.lastReport=a;
	}
	public void setLanguage(int language){
		this.lng=language;
	}
	public void setMusic(float music){
		this.msc=music;
	}
}



 