package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.KPI;
import pe.edu.upc.spring.repository.IKPIRepository;
import pe.edu.upc.spring.service.IKPIService;

@Service
public class KPIServiceImpl implements IKPIService{

	@Autowired
	private IKPIRepository dKPI;
	
	@Override
	@Transactional
	public boolean grabar(KPI kpi) {
		KPI objKPI = dKPI.save(kpi);
		if(objKPI == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idKPI) {
		dKPI.deleteById(idKPI);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<KPI> listarId(int idKPI) {
		return dKPI.findById(idKPI);
	}

	@Override
	@Transactional(readOnly = true)
	public List<KPI> listar() {
		return dKPI.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<KPI> buscarKPI(String kPI) {
		return dKPI.buscarKPI(kPI);
	}
	
}
