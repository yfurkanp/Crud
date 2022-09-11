package springbootCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import springbootCrud.model.Kisi;
import springbootCrud.repository.KisiRepository;

@Service
public class KisiService {
	
	public static KisiRepository kisiRepository;
	
	//Dependency Injection bunu yapmayıp klasik yöntemle çağırsaydık birbirne sıkı sıkı bağlı olacaktı ,  birinin 
	//ömrü ötekine bağlı oluyor ,  biri oluşmadan diğeri oluşturulmuyor ve kolay ayrılmıyor
	
	@Autowired //Spring buna ihtiyaç duyduğunda(çalıştırıldığında) , oluşturuyor ,  alttaki tetiklenmeden boşuna çalışmaz 
	public KisiService(KisiRepository kisiRepo) {
		KisiService .kisiRepository = kisiRepo;
		//   =
		//this de yazılabilir.
	}
	
	//veri tabanına kişi ekleyen method
	
	public  Kisi kisiEkle(Kisi kisi) {
		return kisiRepository.save(kisi); // repos. jpa sayesinde database'e kisi verileri kaydoldu
	}
	
	//databaseden tüm listeyi getir.
	public List<Kisi> tumKisileriGetir(){
		return kisiRepository.findAll();
	}
	
	//id ile kisi silme
	public String idIleKisiSil(Integer id){
		if(kisiRepository.findById(id)==null) {
			throw new EmptyResultDataAccessException(id);
		}
		
		kisiRepository.deleteById(id);
		return id + "id'li kisi silindi";
	}
	
	//PUT
	//PUT , kaynağın var olup olmadığını kontrol etmek içindir,
	//aksi takdirde yeni kaynak oluşturmak içindir.
	
	
	public Kisi kisiGuncelle(Kisi guncelKisi) {
		return kisiRepository.save(guncelKisi);
	}
	
	public Kisi idIleKisiGuncelle(Integer id,Kisi yamaliKisi) {
	Kisi oldKisi =	kisiRepository.findById(id).orElseThrow(()-> new IllegalStateException(id+"li kisi bulanamadı"));
		if(yamaliKisi.getAd()!= null) {
			oldKisi.setAd(yamaliKisi.getAd());
		}
		
		if(yamaliKisi.getSoyad()!= null) {
			oldKisi.setSoyad(yamaliKisi.getSoyad());
		}
		
		if(yamaliKisi.getYas()!= 0) {
			oldKisi.setYas(yamaliKisi.getYas());
		}
		
	  return 	kisiRepository.save(oldKisi);
	}
}
