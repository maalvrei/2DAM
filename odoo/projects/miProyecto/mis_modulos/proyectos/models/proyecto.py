from odoo import fields, models

class Proyecto(models.Model):
		# El nombre técnico del modelo
		# Usualmente en formato 'nombre_del_modulo.nombre_del_modelo' 
    _name = "proyectos.proyecto"  
		# Una descripción para el modelo
    _description = 'Proyecto' 
		# Se define un primer campo de ejemplo llamado name 
		# 'string' es opcional y define el nombre del campo en la vista
    name = fields.Char(string='Nombre')
    description = fields.Text(string='Descripción')
    start_date = fields.Date(string='Fecha de inicio')
    end_date = fields.Date(string='Fecha de fin')
    manager_id = fields.Many2one(comodel_name='res.users', string='Manager')
    state = fields.Selection(selection=[
        ('N', 'Nuevo'), # Público general
        ('EP', 'En progreso'), # Se recomienda la compañía de un adulto
        ('T', 'Terminado'), # Mayores de 13 
    ],string='Estado del proyecto')
    user_ids = fields.Many2many(comodel_name='res.users', string="Usuarios")
    budget = fields.Float(string='Presupuesto')
    priority = fields.Selection(selection=[
        ('A','Alta'),
        ('M', 'Media'),
        ('B','Baja'),
    ],string='Prioridad del proyecto')
    tarea_ids = fields.One2many('proyectos.tarea', 'proyecto_id', string='Tareas')