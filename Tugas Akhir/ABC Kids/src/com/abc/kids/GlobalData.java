package com.abc.kids;



public class GlobalData {

	private static GlobalData mInstance=null;
	public long iduser=0;
	public int [] max_number = new int []{68,46,66};
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
			 { R.drawable.flo_1,R.drawable.flo_2,R.drawable.flo_3,R.drawable.flo_4,R.drawable.flo_5,R.drawable.flo_6,
			   R.drawable.flo_7,R.drawable.flo_8,R.drawable.flo_9,R.drawable.flo_10,R.drawable.flo_11,R.drawable.flo_12,
			   R.drawable.flo_13,R.drawable.flo_14,R.drawable.flo_15,R.drawable.flo_16,R.drawable.flo_17,R.drawable.flo_18,
			   R.drawable.flo_19,R.drawable.flo_20,R.drawable.flo_21,R.drawable.flo_22,R.drawable.flo_23,R.drawable.flo_24,
			   R.drawable.flo_25,R.drawable.flo_26,R.drawable.flo_27,R.drawable.flo_28,R.drawable.flo_29,R.drawable.flo_30,
			   R.drawable.flo_31,R.drawable.flo_32,R.drawable.flo_33,R.drawable.flo_34,R.drawable.flo_35,R.drawable.flo_36,
			   R.drawable.flo_37,R.drawable.flo_38,R.drawable.flo_39,R.drawable.flo_40,R.drawable.flo_41,R.drawable.flo_42,
			   R.drawable.flo_43,R.drawable.flo_44,R.drawable.flo_45,R.drawable.flo_46},
			 { R.drawable.fru_1,R.drawable.fru_2,R.drawable.fru_3,R.drawable.fru_4,R.drawable.fru_5,R.drawable.fru_6,
			   R.drawable.fru_7,R.drawable.fru_8,R.drawable.fru_9,R.drawable.fru_10,R.drawable.fru_11,R.drawable.fru_12,
		       R.drawable.fru_13,R.drawable.fru_14,R.drawable.fru_15,R.drawable.fru_16,R.drawable.fru_17,R.drawable.fru_18,
		       R.drawable.fru_19,R.drawable.fru_20,R.drawable.fru_21,R.drawable.fru_22,R.drawable.fru_23,R.drawable.fru_24,
		       R.drawable.fru_25,R.drawable.fru_26,R.drawable.fru_27,R.drawable.fru_28,R.drawable.fru_29,R.drawable.fru_30,
		       R.drawable.fru_31,R.drawable.fru_32,R.drawable.fru_33,R.drawable.fru_34,R.drawable.fru_35,R.drawable.fru_36,
		       R.drawable.fru_37,R.drawable.fru_38,R.drawable.fru_39,R.drawable.fru_40,R.drawable.fru_41,R.drawable.fru_42,
		       R.drawable.fru_43,R.drawable.fru_44,R.drawable.fru_45,R.drawable.fru_46,R.drawable.fru_47,R.drawable.fru_48,
		       R.drawable.fru_49,R.drawable.fru_50,R.drawable.fru_51,R.drawable.fru_52,R.drawable.fru_53,R.drawable.fru_54,
		       R.drawable.fru_55,R.drawable.fru_56,R.drawable.fru_57,R.drawable.fru_58,R.drawable.fru_59,R.drawable.fru_60,
		       R.drawable.fru_61,R.drawable.fru_62,R.drawable.fru_63,R.drawable.fru_64,R.drawable.fru_65,R.drawable.fru_66 
		       }}; 
	 
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
	 
	public int [] voice_indonesia = new int []{R.raw.a_indo,R.raw.b_indo,R.raw.c_indo,R.raw.d_indo,R.raw.e_indo,R.raw.f_indo,R.raw.g_indo,R.raw.h_indo,R.raw.i_indo,
											   R.raw.j_indo,R.raw.k_indo,R.raw.l_indo,R.raw.m_indo,R.raw.n_indo,R.raw.o_indo,R.raw.p_indo,R.raw.q_indo,R.raw.r_indo,
											   R.raw.s_indo,R.raw.t_indo,R.raw.u_indo,R.raw.v_indo,R.raw.w_indo,R.raw.x_indo,R.raw.y_indo,R.raw.z_indo,R.raw.bagus_indo,
											   R.raw.hebat_indo,R.raw.tidak_indo,R.raw.acai_ind,R.raw.allium_indo,R.raw.alpukat,R.raw.anemone_indo,R.raw.anggrek,R.raw.anggur,
											   R.raw.apel,R.raw.aprikot_indo,R.raw.ara,R.raw.aster_indo,};
	public int [] voice_english = new int   []{R.raw.a_eng,R.raw.b_eng,R.raw.c_eng,R.raw.d_eng,R.raw.e_eng,R.raw.f_eng,R.raw.g_eng,R.raw.h_eng,R.raw.i_eng,R.raw.j_eng,
											   R.raw.k_eng,R.raw.l_eng,R.raw.m_eng,R.raw.n_eng,R.raw.o_eng,R.raw.p_eng,R.raw.q_eng,R.raw.r_eng,R.raw.s_eng,R.raw.t_eng,
											   R.raw.u_eng,R.raw.v_eng,R.raw.w_eng,R.raw.x_eng,R.raw.y_eng,R.raw.z_eng,R.raw.good_job,
											   R.raw.excellent_eng,R.raw.notbad_eng,R.raw.acai_eng,R.raw.allium,R.raw.anemone,R.raw.apple,
											   R.raw.aprikot_eng,R.raw.aster,R.raw.avocado};
	
	public int [] voice_animal_indo = new int[]{ R.raw.angsa,R.raw.anjing,R.raw.anjing_hutan,R.raw.ayam};
	public int [] voice_animal_english = new int[] {R.raw.albatross_eng,R.raw.antelope,};
	
	
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



 