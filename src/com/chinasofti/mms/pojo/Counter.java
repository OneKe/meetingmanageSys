package com.chinasofti.mms.pojo;

public class Counter {
    
    private String visitcount;

	public String getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((visitcount == null) ? 0 : visitcount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		if (visitcount == null) {
			if (other.visitcount != null)
				return false;
		} else if (!visitcount.equals(other.visitcount))
			return false;
		return true;
	}

	public Counter() {
		
	}
	
	public Counter(String visitcount) {
		this.visitcount = visitcount;
	}

	@Override
	public String toString() {
		return "Counter [visitcount=" + visitcount + "]";
	}

    
    
}