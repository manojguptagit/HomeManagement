/***************************************************************
 * Project Name: HomeManagement
 * 
 * File Name: FeedJobsStartTimeVO.java
 * 
 * Author: Manoj Kumar Gupta, Created on 6 Apr 2015 at 16:31:23
 * 
 * *************************************************************
 * 2015 Home Management Project
 * *************************************************************/

package org.home.management.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author guptam22
 * 
 */
@Entity
@Table( name = "FeedJobsStartTime" )
@NamedQueries( value = {
		@NamedQuery( name = "selectAll", query = "FROM FeedJobsStartTimeVO" ),
		@NamedQuery( name = "selectAllById", query = "FROM FeedJobsStartTimeVO where FeedPK in (:ids)" ),
		@NamedQuery( name = "selectById", query = "FROM FeedJobsStartTimeVO where FeedPK=:id" ) } )
public class FeedJobsStartTimeVO {

	@Id
	@Column( nullable = false, name = "FeedPK" )
	private Long feedPK;

	@Column( nullable = false, name = "MO" )
	private Integer mo;

	@Column( nullable = false, name = "TU" )
	private Integer tu;

	@Column( nullable = false, name = "WE" )
	private Integer we;

	@Column( nullable = false, name = "TH" )
	private Integer th;

	@Column( nullable = false, name = "FR" )
	private Integer fr;

	@Column( nullable = false, name = "SA" )
	private Integer sa;

	@Column( nullable = false, name = "SU" )
	private Integer su;

	@Column( nullable = true, name = "StartTime" )
	@Temporal( TemporalType.TIME )
	private Date startTime;

	@Column( nullable = true, name = "EndTime" )
	@Temporal( TemporalType.TIME )
	private Date endTime;

	@Column( nullable = false, name = "StartMins" )
	private String startMins;

	@Column( nullable = false, name = "StatusRun" )
	private String statusRun;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( this.getClass() != obj.getClass() ) {
			return false;
		}
		FeedJobsStartTimeVO other = ( FeedJobsStartTimeVO ) obj;
		if ( this.endTime == null ) {
			if ( other.endTime != null ) {
				return false;
			}
		} else if ( !this.endTime.equals( other.endTime ) ) {
			return false;
		}
		if ( this.feedPK == null ) {
			if ( other.feedPK != null ) {
				return false;
			}
		} else if ( !this.feedPK.equals( other.feedPK ) ) {
			return false;
		}
		if ( this.fr == null ) {
			if ( other.fr != null ) {
				return false;
			}
		} else if ( !this.fr.equals( other.fr ) ) {
			return false;
		}
		if ( this.mo == null ) {
			if ( other.mo != null ) {
				return false;
			}
		} else if ( !this.mo.equals( other.mo ) ) {
			return false;
		}
		if ( this.sa == null ) {
			if ( other.sa != null ) {
				return false;
			}
		} else if ( !this.sa.equals( other.sa ) ) {
			return false;
		}
		if ( this.startMins == null ) {
			if ( other.startMins != null ) {
				return false;
			}
		} else if ( !this.startMins.equals( other.startMins ) ) {
			return false;
		}
		if ( this.startTime == null ) {
			if ( other.startTime != null ) {
				return false;
			}
		} else if ( !this.startTime.equals( other.startTime ) ) {
			return false;
		}
		if ( this.statusRun == null ) {
			if ( other.statusRun != null ) {
				return false;
			}
		} else if ( !this.statusRun.equals( other.statusRun ) ) {
			return false;
		}
		if ( this.su == null ) {
			if ( other.su != null ) {
				return false;
			}
		} else if ( !this.su.equals( other.su ) ) {
			return false;
		}
		if ( this.th == null ) {
			if ( other.th != null ) {
				return false;
			}
		} else if ( !this.th.equals( other.th ) ) {
			return false;
		}
		if ( this.tu == null ) {
			if ( other.tu != null ) {
				return false;
			}
		} else if ( !this.tu.equals( other.tu ) ) {
			return false;
		}
		if ( this.we == null ) {
			if ( other.we != null ) {
				return false;
			}
		} else if ( !this.we.equals( other.we ) ) {
			return false;
		}
		return true;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return this.endTime;
	}

	/**
	 * @return the feedPK
	 */
	public Long getFeedPK() {
		return this.feedPK;
	}

	/**
	 * @return the fr
	 */
	public Integer getFr() {
		return this.fr;
	}

	/**
	 * @return the mo
	 */
	public Integer getMo() {
		return this.mo;
	}

	/**
	 * @return the sa
	 */
	public Integer getSa() {
		return this.sa;
	}

	/**
	 * @return the startMins
	 */
	public String getStartMins() {
		return this.startMins;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return this.startTime;
	}

	/**
	 * @return the statusRun
	 */
	public String getStatusRun() {
		return this.statusRun;
	}

	/**
	 * @return the su
	 */
	public Integer getSu() {
		return this.su;
	}

	/**
	 * @return the th
	 */
	public Integer getTh() {
		return this.th;
	}

	/**
	 * @return the tu
	 */
	public Integer getTu() {
		return this.tu;
	}

	/**
	 * @return the we
	 */
	public Integer getWe() {
		return this.we;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ( ( this.endTime == null ) ? 0 : this.endTime.hashCode() );
		result = prime * result
				+ ( ( this.feedPK == null ) ? 0 : this.feedPK.hashCode() );
		result = prime * result
				+ ( ( this.fr == null ) ? 0 : this.fr.hashCode() );
		result = prime * result
				+ ( ( this.mo == null ) ? 0 : this.mo.hashCode() );
		result = prime * result
				+ ( ( this.sa == null ) ? 0 : this.sa.hashCode() );
		result = prime * result
				+ ( ( this.startMins == null ) ? 0 : this.startMins.hashCode() );
		result = prime * result
				+ ( ( this.startTime == null ) ? 0 : this.startTime.hashCode() );
		result = prime * result
				+ ( ( this.statusRun == null ) ? 0 : this.statusRun.hashCode() );
		result = prime * result
				+ ( ( this.su == null ) ? 0 : this.su.hashCode() );
		result = prime * result
				+ ( ( this.th == null ) ? 0 : this.th.hashCode() );
		result = prime * result
				+ ( ( this.tu == null ) ? 0 : this.tu.hashCode() );
		result = prime * result
				+ ( ( this.we == null ) ? 0 : this.we.hashCode() );
		return result;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime( Date endTime ) {
		this.endTime = endTime;
	}

	/**
	 * @param feedPK
	 *            the feedPK to set
	 */
	public void setFeedPK( Long feedPK ) {
		this.feedPK = feedPK;
	}

	/**
	 * @param fr
	 *            the fr to set
	 */
	public void setFr( Integer fr ) {
		this.fr = fr;
	}

	/**
	 * @param mo
	 *            the mo to set
	 */
	public void setMo( Integer mo ) {
		this.mo = mo;
	}

	/**
	 * @param sa
	 *            the sa to set
	 */
	public void setSa( Integer sa ) {
		this.sa = sa;
	}

	/**
	 * @param startMins
	 *            the startMins to set
	 */
	public void setStartMins( String startMins ) {
		this.startMins = startMins;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime( Date startTime ) {
		this.startTime = startTime;
	}

	/**
	 * @param statusRun
	 *            the statusRun to set
	 */
	public void setStatusRun( String statusRun ) {
		this.statusRun = statusRun;
	}

	/**
	 * @param su
	 *            the su to set
	 */
	public void setSu( Integer su ) {
		this.su = su;
	}

	/**
	 * @param th
	 *            the th to set
	 */
	public void setTh( Integer th ) {
		this.th = th;
	}

	/**
	 * @param tu
	 *            the tu to set
	 */
	public void setTu( Integer tu ) {
		this.tu = tu;
	}

	/**
	 * @param we
	 *            the we to set
	 */
	public void setWe( Integer we ) {
		this.we = we;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedJobsStartTimeVO [feedPK=" + this.feedPK + ", mo=" + this.mo
				+ ", tu=" + this.tu + ", we=" + this.we + ", th=" + this.th
				+ ", fr=" + this.fr + ", sa=" + this.sa + ", su=" + this.su
				+ ", startTime=" + this.startTime + ", endTime=" + this.endTime
				+ ", startMins=" + this.startMins + ", statusRun="
				+ this.statusRun + "]";
	}

}
