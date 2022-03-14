package com.studycase.airline_ticketing_system.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.dataAccess.concrete.PurchaseDao;
import com.studycase.airline_ticketing_system.entities.Airport;
import com.studycase.airline_ticketing_system.entities.Purchase;
import com.studycase.airline_ticketing_system.utilities.messages.Messages;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorDataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;
import com.studycase.airline_ticketing_system.utilities.results.SuccessDataResult;
import com.studycase.airline_ticketing_system.utilities.results.SuccessResult;

@Service
public class PurchaseManager implements EntityService<Purchase> {

	private PurchaseDao purchaseDao;

	@Autowired
	public PurchaseManager(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	public String maskCardNumber(String cardNumber) {
		
		cardNumber=cardNumber.replaceAll("[$-/:-?{-~!\"^_`\\[\\]]", "");
		cardNumber=cardNumber.substring(0,6)+"******"+cardNumber.substring(12,cardNumber.length());
		return cardNumber;
	}
	@Override
	public Result add(Purchase entity) {
		if (entity != null) {
			entity.setCardNumber(maskCardNumber(entity.getCardNumber()));
			Purchase purchase = purchaseDao.save(entity);
			if (purchase != null)
				return new SuccessDataResult<Purchase>(purchase, Messages.entityAdded);
		}

		return new ErrorDataResult<Airport>(Messages.entityCouldntAdd);

	}

	@Override
	public DataResult<List<Purchase>> getAll() {
		List<Purchase> purchases = this.purchaseDao.findAll();
		if (purchases == null) {
			return new ErrorDataResult<List<Purchase>>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<List<Purchase>>(purchases, Messages.entitiesListed);
	}


	@Override
	public Result delete(int id) {
		this.purchaseDao.deleteById(id);
		return new SuccessResult(Messages.entityDeleted);
	}

	@Override
	public DataResult<Purchase> search(String airportName) {
		return null;

	}
	
}
