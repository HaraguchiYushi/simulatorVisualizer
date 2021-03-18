package com.yushi.simulator.data.data;

import lombok.Data;

@Data
public class Column {
	private String cycle;
	private String stage1;
	private String stage2;
	private String stage3;
	private String stage4;
	private String stage5;
	private String stage6;
	private String stage7;
	
	public Column() {}
	public Column(String cycle) {
		this.cycle = cycle;
	}
}