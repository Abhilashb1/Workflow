$(document).ready(function() {
		
		var chart = AmCharts.makeChart("chartdiv", {
		    "theme": "light",
		    "type": "serial",
		    "legend": {
		        "horizontalGap": 10,
		        "useGraphSettings": true,
		        "markerSize": 10,
		        "color":"#FFFFFF"
		      },
		    "dataProvider": [{
		        "month": "Jan",
		        "totalCapacity": 4200,
		        "usedCapacity": 3500
		    }, {
		        "month": "Feb",
		        "totalCapacity": 3700,
		        "usedCapacity": 1100
		    }, {
		        "month": "Mar",
		        "totalCapacity": 2900,
		        "usedCapacity": 2800
		    }, {
		        "month": "Apr",
		        "totalCapacity": 2600,
		        "usedCapacity": 2300
		    }, {
		        "month": "May",
		        "totalCapacity": 3400,
		        "usedCapacity": 2100
		    }, {
		        "month": "Jun",
		        "totalCapacity": 4900,
		        "usedCapacity": 2900
		    }, {
		        "month": "Jul",
		        "totalCapacity": 8400,
		        "usedCapacity": 7200
		    }, {
		        "month": "Aug",
		        "totalCapacity": 4000,
		        "usedCapacity": 3100
		    },
		    {
		        "month": "Sep",
		        "totalCapacity": 8000,
		        "usedCapacity": 3100
		    },
		    {
		        "month": "Oct",
		        "totalCapacity": 5000,
		        "usedCapacity": 1100
		    },
		    {
		        "month": "Nov",
		        "totalCapacity": 6000,
		        "usedCapacity": 2100
		    },{
		        "month": "Dec",
		        "totalCapacity": 1000,
		        "usedCapacity": 7100
		    }],
		    "startDuration": 1,
		    "graphs": [{
		        "balloonText": "Total capacity used in: <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "title": "Total capacity used",
		        "type": "column",
		        "valueField": "usedCapacity",
		    	"color"    : "White"
		    }, {
		        "balloonText": "Total capacity available in: <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "title": "Total capacity available",
		        "type": "column",
		        "valueField": "totalCapacity",
		       	"color"    : "White"
		        
		    }],
		    "plotAreaFillAlphas": 0.1,
			"color"    : "White",
		    "categoryField": "month",
		    "categoryAxis": {
		        "gridPosition": "start"
		    },
		    "export": {
		    	"enabled": true
		     }
		});
		jQuery('.chart-input').off().on('input change',function() {
			var property	= jQuery(this).data('property');
			var target		= chart;
			chart.startDuration = 0;

			if ( property == 'topRadius') {
				target = chart.graphs[0];
		      	if ( this.value == 0 ) {
		          this.value = undefined;
		      	}
			}

			target[property] = this.value;
			chart.validateNow();
		});
		
		var chart1;
		var legend;
		var selected;

		var types = [{
		  type: "Agile",
		  percent: 70,
		  color: "#ff9e01",
		  subs: [{
		    type: "TDD",
		    percent: 15
		  }, {
		    type: "Express",
		    percent: 35
		  }, {
		    type: "Misc",
		    percent: 20
		  }]
		}, {
		  type: "Waterfall",
		  percent: 30,
		  color: "#b0de09",
		  subs: [{
		    type: "TDD",
		    percent: 15
		  }, {
		    type: "RMP",
		    percent: 10
		  }, {
		    type: "Misc",
		    percent: 5
		  }]
		}];

		function generateChartData1() {
		  var chartData1 = [];
		  for (var i = 0; i < types.length; i++) {
		    if (i == selected) {
		      for (var x = 0; x < types[i].subs.length; x++) {
		        chartData1.push({
		          type: types[i].subs[x].type,
		          percent: types[i].subs[x].percent,
		          color: types[i].color,
		          pulled: true
		        });
		      }
		    } else {
		      chartData1.push({
		        type: types[i].type,
		        percent: types[i].percent,
		        color: types[i].color,
		        id: i
		      });
		    }
		  }
		  return chartData1;
		}

		AmCharts.makeChart("chartdivPie", {
		  "type": "pie",
		"theme": "light",
		 "legend": {
		        "horizontalGap": 10,
		        "useGraphSettings": true,
		        "markerSize": 10,
		        "color":"#FFFFFF"
		      },
		  "dataProvider": generateChartData1(),
		  "labelText": "[[title]]: [[value]]",
		  "balloonText": "[[title]]: [[value]]",
		  "titleField": "type",
		  "valueField": "percent",
		  "outlineColor": "#FFFFFF",
		  "color":"#FFFFFF",
		  "outlineAlpha": 0.8,
		  "outlineThickness": 2,
		  "colorField": "color",
		  "pulledField": "pulled",
		  "titles": [{
		    "text": "Click a slice to see the details"
		  }],
		  "listeners": [{
		    "event": "clickSlice",
		    "method": function(event) {
		      var chart1 = event.chart;
		      if (event.dataItem.dataContext.id != undefined) {
		        selected = event.dataItem.dataContext.id;
		      } else {
		        selected = undefined;
		      }
		      chart1.dataProvider = generateChartData1();
		      chart1.validateData();
		    }
		  }],
		  "export": {
		    "enabled": true
		  }
		});
		
		
		
		
		var chart = AmCharts.makeChart("chartdivTeamCapacity", {
		    "theme": "dark",
		    "type": "serial",
		    "legend": {
		        "horizontalGap": 10,
		        "useGraphSettings": true,
		        "markerSize": 10,
		        "color":"#FFFFFF"
		      },
		    "dataProvider": [{
		        "month": "Jan",
		        "totalCapacity": 4000,
		        "usedCapacityProj": 3000,
		        "usedCapacityMisc": 1000
		    }, {
		        "month": "Feb",
		        "totalCapacity": 5000,
		        "usedCapacityProj": 3000,
		        "usedCapacityMisc": 1000
		    }, {
		        "month": "Mar",
		        "totalCapacity": 6000,
		        "usedCapacityProj": 4000,
		        "usedCapacityMisc": 2000
		    }, {
		        "month": "Apr",
		        "totalCapacity": 4500,
		        "usedCapacityProj": 2500,
		        "usedCapacityMisc": 1000
		    }, {
		        "month": "May",
		        "totalCapacity": 6000,
		        "usedCapacityProj": 5000,
		        "usedCapacityMisc": 500
		    }, {
		        "month": "Jun",
		        "totalCapacity": 4700,
		        "usedCapacityProj": 2000,
		        "usedCapacityMisc": 1000
		    }, {
		        "month": "Jul",
		        "totalCapacity": 8400,
		        "usedCapacityProj": 7200,
		        "usedCapacityMisc": 1200
		    }, {
		        "month": "Aug",
		        "totalCapacity": 7000,
		        "usedCapacityProj": 3100,
		        "usedCapacityMisc": 1400
		    },
		    {
		        "month": "Sep",
		        "totalCapacity": 8000,
		        "usedCapacityProj": 3700,
		        "usedCapacityMisc": 2500
		    },
		    {
		        "month": "Oct",
		        "totalCapacity": 5000,
		        "usedCapacityProj": 2100,
		        "usedCapacityMisc": 1500
		    },
		    {
		        "month": "Nov",
		        "totalCapacity": 6000,
		        "usedCapacityProj": 4100,
		        "usedCapacityMisc": 1700
		    },{
		        "month": "Dec",
		        "totalCapacity": 9000,
		        "usedCapacityProj": 7100,
		        "usedCapacityMisc": 200
		    }],
		    "startDuration": 1,
		    "graphs": [
		               {
		        "balloonText": "Total capacity used for Misc tasks: <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "title": "Used capacity for miscellaneous tasks",
		        "type": "column",
		        "valueField": "usedCapacityMisc",
		       	"color"    : "White"
		        
		    },
		    {
		        "balloonText": "Total capacity used for Projects+regression: <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "title": "Used capacity for projects + regression",
		        "type": "column",
		        "valueField": "usedCapacityProj",
		    	"color"    : "White"
		    }, {
		        "balloonText": "Total capacity available in: <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "title": "Total capacity available",
		        "type": "column",
		        "valueField": "totalCapacity",
		       	"color"    : "White"
		        
		    }
		    ],
		    "plotAreaFillAlphas": 0.1,
			"color"    : "White",
		    "categoryField": "month",
		    "categoryAxis": {
		        "gridPosition": "start"
		    },
		    "export": {
		    	"enabled": true
		     }
		});
		jQuery('.chart-input').off().on('input change',function() {
			var property	= jQuery(this).data('property');
			var target		= chart;
			chart.startDuration = 0;

			if ( property == 'topRadius') {
				target = chart.graphs[0];
		      	if ( this.value == 0 ) {
		          this.value = undefined;
		      	}
			}

			target[property] = this.value;
			chart.validateNow();
		});
		
		
		
		
		
	
	});