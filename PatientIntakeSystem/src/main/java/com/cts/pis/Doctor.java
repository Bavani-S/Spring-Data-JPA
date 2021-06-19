package com.cts.pis;

public enum Doctor {
	DrTRULUCK("Dr.Truluck-Cardiologist"),
	DrFILLMORE("Dr.Fillmore-Dentist"),
	DrHOLLER("Dr.Holler-Orthodontist"),
	DrTANNER("Dr.Tanner-Dermatologist"),
	DrKLOTZ("Dr.Klotz-ENT"),
	DrSAMKOFF("Dr.Samkoff-Epidemiologist"),
	DrHEINE("Dr.Heine-Gastroenterologist"),
	DrFOLEY("Dr.Foley-Neurologist"),
	DrHATCHER("Dr.Hatcher-Gynecologist"),
	DrPAYNE("Dr.Payne-Gynecologist"),
	DrLUKES("Dr.Lukes-Oncologist"),
	DrELFMAN("Dr.Elfman-Pediatrician"),
	DrBLATTER("Dr.Blatter-Pediatrician"),
	DrSTRANGE("Dr.Strange-Psychiatrist"),
	DrHACKMAN("Dr.Hackman-Surgeon"),
	DrBLADES("Dr.Blades-Surgeon");
	private String doctor;

	private Doctor(String doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return doctor;
	}
}
