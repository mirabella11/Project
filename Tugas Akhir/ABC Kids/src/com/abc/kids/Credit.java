package com.abc.kids;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class Credit extends ListActivity {
	private TextView credit ;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_file);
        credit = (TextView) findViewById(R.id.cred);
        
        String[] values = new String[] {"Programmer :\nMirabella Dian Wahyudi Putri","Designer : Octe Reviyanto Nugroho","www.static.howstuffworks.com",
        								"www.photo-dictionary.com","www.flowerclip.com","www.teleflora.com","www.tropicalplantbook.com","stvarukusa.rs",
        								"www.virginmedia.com","www.farmersalmanac.com","www.pokka.com.sg","www.rayner.us","pomegranates.org","2.imimg.com",
        								"www.publicdomainpictures.net","www.vanwhole-produce.com","www.nutfruit.org","meyerlemontree.com","www.probioticsmart.com",
        								"us.123rf.com","ichef.bbci.co.uk","upload.wikimedia.org","www.plantlife.org.uk","www.dfwvapor.com","www.pamsclipart.com",
        								"www.evape.co.uk","images.wisegeek.com","www.clker.com","juang.info","www.cyberfresh.com.au",
        								"homefoodsafety.org","blogdefarmacia.com","images.pictureshunt.com","www.clker.com","clipartsy.com",
        								"anastasiia-ku.com","www.my-healthy-eating-secrets.com","www.tattoospotter.com","pixabay.com",
        								"www.mylatestdistraction.com","www.weirdspace.dk","www.cartoonwatcher.com","images.wikia.com","rlv.zcache.com",
        								"www.birdorable.com","www.wpclipart.com","www.birdorable.com","www.sweetclipart.com","gardening.yardener.com",
        								"www.teachingcollegeenglish.com","bestclipartblog.com","us.cdn4.123rf.com","rlv.zcache.ca","aux.iconpedia.net", "www.how-to-draw-cartoons-online.com", 
        								"rlv.zcache.co.uk","www.my2fun.com","americansingercanaries.com"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
       setListAdapter(adapter);
        
	}

}
