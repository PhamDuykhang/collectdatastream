function [info,vector] = ExtractFeature(dicompath)
    format shortG
    info = dicominfo(dicompath); % ??i s? là ???ng dãn file t?o thành hình ?nh nh? phân c?a vùng xu?t huy?t
    RescaleSlope = info.RescaleSlope;
    RescaleIntercept = info.RescaleIntercept; % tính toán RescaleSlope và RescaleIntercept
    I = dicomread(info);
    [r , c] = size(I);
    hematoma = zeros(r,c);
    for i = 1:r
        for j = 1:c
            hu= (I(i,j)*RescaleSlope + RescaleIntercept);
            if hu>40 && hu<90
                hematoma(i,j)=1;
            else
                hematoma(i,j)=0;
            end
        end
    end
 
    imshow(hematoma); 
%   im2= bwmorph(hematoma,'open');
    structure_element = strel('disk',5);
    im2 = imopen(hematoma,structure_element);
    CC = bwconncomp(im2);
    if CC.NumObjects ~= 0 
        S = regionprops(CC, 'Area');
        thresholdpixel = max([S.Area]);
        im2 = bwareaopen(im2,thresholdpixel);
%         imshow(im2)
        s = regionprops('table',im2,'BoundingBox','Area','centroid','EquivDiameter','FilledArea','ConvexArea','Solidity','Extent','Eccentricity','MajorAxisLength','MinorAxisLength','Orientation');
  %_--------------------------------------
          skull = zeros(r,c);
          for i= 1:r
            for j = 1:c
                HU = (I(i,j) * RescaleSlope + RescaleSlope);
                if HU >200
                    skull(i,j) = 1; %img(i,j): binary img (1:white, 0:black)
                else 
                    skull(i,j) = 0;
                end
            end
          end
          CC = bwconncomp(skull);
          sthe = regionprops(CC, 'Area');
          thresholdpixel = max([sthe.Area]);
          skull = bwareaopen(skull,thresholdpixel);
          %imshow(skull)
          propertiesSkull = regionprops(skull,'centroid');
          centroidSkull = cat(1, propertiesSkull.Centroid);
          X1=centroidSkull(:,1);
          Y1=centroidSkull(:,2);
          %_-------=------------------------------------------
          Centroid0fhematoma= s.Centroid;
          X2=Centroid0fhematoma(:,1);
          Y2=Centroid0fhematoma(:,2);
          %-----------------
          %Tính kho?n cách.
          distance= sqrt((X1-X2)^2+(Y1-Y2)^2);
          %-----------
          Area = s.Area;
          CX=X2;
          CY=Y2;
          Perimeter =s.EquivDiameter/2 *3.14;
          Diameter=s.EquivDiameter/2;
          Solidity=s.Solidity;
          ConvexArea = s.ConvexArea;
          boudingbox = cat(1,s.BoundingBox);
          ULX=boudingbox(1);
          ULY=boudingbox(2);
          BodingWith = boudingbox(3);
          BodingHeight = boudingbox(4);
          FilledArea= s.FilledArea;
          Extent = s.Extent;
          Eccentricity=s.Eccentricity;
          Maj = s.MajorAxisLength;
          Min = s.MinorAxisLength;
          Orientation =s.Orientation; 
    else
        imshow(im2);
          Area = 0;
          CX=0;
          CY=0;
          Perimeter =0;
          Diameter=0;
          Solidity=0;
          ConvexArea = 0;
          ULX=0;
          ULY=0;
          BodingWith = 0;
          BodingHeight = 0;
          FilledArea=0;
          Extent = 0;
          Eccentricity=0;
          Maj = 0;
          Min = 0;
          Orientation =0;
          distance=0;
    end
    
%   
%   title(dicompath);
  
  %---------------
  %--------------
  name=char(info.PatientName.FamilyName);
  patientID=char(info.PatientID);
  patientAge=char(info.PatientAge);
  patientSex=char(info.PatientSex);
  accessionNumber=char(info.AccessionNumber);
  modality=char(info.Modality);
  manufacturer=char(info.Manufacturer);
  institutionName=char(info.InstitutionName);
  institutionAddress=char(info.InstitutionAddress);
  spacechar=char(':');
  %-----------
  %list feature
  %-----------
  info = [patientID,spacechar,name,spacechar,patientAge,spacechar,patientSex,spacechar,institutionName,spacechar,institutionAddress,spacechar,accessionNumber,spacechar,manufacturer,spacechar,modality];
  vector = [Area,CX,CY,Perimeter,distance,Diameter,Solidity,ConvexArea,ULX,ULY,BodingWith,BodingHeight,FilledArea,Extent,Eccentricity,Maj,Min,Orientation];
 end
    